package com.tgy.mvcframework.servlet;


import com.tgy.mvcframework.annotation.GYAutowired;
import com.tgy.mvcframework.annotation.GYController;
import com.tgy.mvcframework.annotation.GYRequestMapping;
import com.tgy.mvcframework.annotation.GYService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * 自定义转发servlet
 *
 * @author DragonSwimDiving
 * @program rewritespring
 * @Date 2019-06-21 18:12
 **/

public class GYDispatcherServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    private static final String LOCATION="contextConfigLocation";

    private Properties p=new Properties();

    private List<String> classNames=new ArrayList<String>();

    private Map<String,Object> ioc=new HashMap<String,Object>();

    private Map<String,Method> handlerMapping=new HashMap<String,Method>();

    public GYDispatcherServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);//开始匹配到对应的方法
        } catch (Exception e){
            //如果匹配过程出现异常，异常信息打印出去
            resp.getWriter().write("500 Exception,Details:\r\n"+Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]]","")
            .replaceAll(",\\s","\r\n"));
        }

    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (this.handlerMapping.isEmpty())return;
        
        String url=req.getRequestURI();
        String contextPath=req.getContextPath();
        url=url.replace(contextPath,"").replaceAll("/+","/");
        if (!this.handlerMapping.containsKey(url)){
            resp.getWriter().write("404 Not Found!!");
            return;
        }
        Map<String,String[]> params=req.getParameterMap();
        Method method=this.handlerMapping.get(url);
        //获取方法的参数列表
        Class<?>[] parameterTypes=method.getParameterTypes();
        //获取请求的参数
        Map<String,String[]> parameterMap=req.getParameterMap();
        //保存参数值
        Object [] paramValues=new Object[parameterTypes.length];
        //方法的参数列表
        for (int i=0;i<parameterTypes.length;i++) {
            //根据参数名称，做某些处理
            Class parameterType=parameterTypes[i];
            if (parameterType==HttpServletRequest.class){
                //参数类型已明确，这边强转类型
                paramValues[i]=req;
                continue;
            }else if (parameterType==HttpServletResponse.class){
                paramValues[i]=resp;
                continue;
            }else if(parameterType==String.class){
                for (Map.Entry<String,String[]> param :parameterMap.entrySet()){
                    String value=Arrays.toString(param.getValue())
                            .replaceAll("\\[|\\]","")
                            .replaceAll(",\\s","," );
                    paramValues[i]=value;
                }
            }
        }
        try {
            String beanName=lowerFirstCase(method.getDeclaringClass().getSimpleName());
            //利用反射机制来调用
            method.invoke(this.ioc.get(beanName),paramValues);
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.加载配置文件
        doLoadConfig(config.getInitParameter(LOCATION));
        //2.扫描所有相关的类
        doScanner(p.getProperty("scanPackage"));
        //3.初始化所有相关的实例，并保存到IOC容器中
        doInstance();
        //4.依赖注入
        doAutowired();
        //5.够造handlerMapping
        initHandlerMapping();

        //6.等待请求，匹配URL,定位方法，反射调用执行
        //调用doGet或者doPost方法

        //提示信息
        System.out.println("TGY MVCframework is init()");

    }

    private void initHandlerMapping() {
        if (ioc.isEmpty())return;
        for (Map.Entry<String,Object> entry:ioc.entrySet()) {
            Class<?> clazz=entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(GYController.class))continue;
            String baseUrl="";
            //获取Method的url配置
            Method [] methods=clazz.getMethods();
            for (Method method:methods){
                //没有加RequestMapping注解的直接忽略
                if (!method.isAnnotationPresent(GYRequestMapping.class)){
                    continue;
                }
                //映射URL
                GYRequestMapping requestMapping=method.getAnnotation(GYRequestMapping.class);
                String url=("/"+baseUrl+"/"+requestMapping.value().replaceAll("/+","/"));
                handlerMapping.put(url,method);
                System.out.println("mapped"+url+","+method);
            }

        }
    }

    private void doAutowired() {
        if (ioc.isEmpty())return;
        for (Map.Entry<String,Object> entry:ioc.entrySet()){
            //拿到实例对象中所有属性
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field: fields ) {
                if (!field.isAnnotationPresent(GYAutowired.class))continue;
                GYAutowired autowired=field.getAnnotation(GYAutowired.class);
                String beanName=autowired.value().trim();
                if ("".equals(beanName)){
                    beanName=field.getType().getName();
                }
                //强制访问
                field.setAccessible(true);
                try {
                    //用反射给字段自动赋值
                    field.set(entry.getValue(),ioc.get(beanName));
                }catch (Exception e){
                    e.printStackTrace();
                    continue;
                }
            }

        }
    }

    private void doInstance() {
        if (classNames.size()==0)return;
        try {
            for (String className:classNames){
                Class<?> clazz=Class.forName(className);
                if (clazz.isAnnotationPresent(GYController.class)){
                    //默认将首字母小写作为beanName
                    String beanName=lowerFirstCase(clazz.getSimpleName());
                    ioc.put(beanName,clazz.newInstance());
                }else if (clazz.isAnnotationPresent(GYService.class)){
                    GYService service=clazz.getAnnotation(GYService.class);
                    String beanName=service.value();
                    //如果用户设置了名字，就用用户自己设置
                    if(!"".equals(beanName.trim())){
                        ioc.put(beanName,clazz.newInstance());
                        continue;
                    }
                    //如果自己没设，就按接口类型创建一个实例
                    Class<?>[] interfaces=clazz.getInterfaces();
                    for (Class<?> i:interfaces) {
                        if (ioc.containsKey(i.getName())){
                            throw new Exception("THE BeanName is exits!!!");
                        }
                      ioc.put(i.getName(),clazz.newInstance());
                    }
                }else {
                    continue;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void doScanner(String packageName) {
        //将所有的包路径转换为文件路径
        URL url=this.getClass().getClassLoader().getResource("/"+packageName.replaceAll("\\.","/"));
        File dir=new File(url.getFile());
        for (File file:dir.listFiles()){
            //如果是文件夹，继续递归
            if (file.isDirectory()){
                doScanner(packageName+"."+file.getName());
            }else {
                classNames.add(packageName+"."+file.getName().replace(".class","").trim());
            }
        }

    }

    private void doLoadConfig(String location) {
        InputStream fis=null;

        //1.读取配置文件
        try {
            fis=this.getClass().getClassLoader().getResourceAsStream(location);
            p.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null!=fis){fis.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 首字母小写
     * @param str
     * @return
     */
    private String lowerFirstCase(String str){
        char [] chars=str.toCharArray();
        chars[0]+=32;
        return String.valueOf(chars);
    }
}
