package com.tgy.beetl.first;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanggy
 * @date 2018/11/8
 */
public class Begin {
    public static void first(){
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("hello,${name}");
        t.binding("name", "beetl");
        String str = t.render();
        System.out.println(str);
    }

    public static void second(){
        String root = System.getProperty("user.dir")+File.separator+"template";
        FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("/webapp/WEB-INF/template/s01/hello.txt");
        String str = t.render();
        System.out.println(str);
    }

    public static void thrid() {
        String root = System.getProperty("user.dir") + File.separator + "template";
        FileResourceLoader resourceLoader = new FileResourceLoader(root, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Map<String,Object> shared = new HashMap<String,Object>();
        shared.put("name", "beetl");
        gt.setSharedVars(shared);
        Template t = gt.getTemplate("/webapp/WEB-INF/template/s01/test.txt");
        String str = t.render();
        System.out.println(str);
    }

    public static void main(String[] args) {
        //first();
        //second();
        thrid();
    }
}
