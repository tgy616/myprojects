package com.tgy.miniapp;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanggy
 * @date 2018/8/4
 */
public class CreateImgUtil {
    /**
     * 私有化构造函数，防止创建本工具类的实例
     */
    private CreateImgUtil() {
    }

    @SuppressWarnings({ "resource" })
    public static String httpPostWithJSON(String url, String json, String id,String dir) throws Exception {
        String result = null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        StringEntity se = new StringEntity(json);
        se.setContentType("application/json");
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "UTF-8"));
        httpPost.setEntity(se);
        HttpResponse response = httpClient.execute(httpPost);
        if (response != null) {
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                InputStream instreams = resEntity.getContent();
                File saveFile = new File(dir + id + ".png");
                // 判断这个文件（saveFile）是否存在
                if (!saveFile.getParentFile().exists()) {
                    // 如果不存在就创建这个文件夹
                    saveFile.getParentFile().mkdirs();
                }
                saveToImgByInputStream(instreams, dir, id + ".png");
            }
        }
        httpPost.abort();
        return result;
    }

    /*
     * @param instreams 二进制流
     *
     * @param imgPath 图片的保存路径
     *
     * @param imgName 图片的名称
     *
     * @return 1：保存正常 0：保存失败
     */
    private static int saveToImgByInputStream(InputStream instreams, String imgPath, String imgName) {

        int stateInt = 1;
        if (instreams != null) {
            try {
                File file = new File(imgPath + imgName);// 可以是任何图片格式.jpg,.png等
                FileOutputStream fos = new FileOutputStream(file);

                byte[] b = new byte[1024];
                int nRead = 0;
                while ((nRead = instreams.read(b)) != -1) {
                    fos.write(b, 0, nRead);
                }
                fos.flush();
                fos.close();
            } catch (Exception e) {
                stateInt = 0;
                e.printStackTrace();
            } finally {
                try {
                    instreams.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return stateInt;
    }

    public static void main(String[] args) {
        //LocalDate today=LocalDate.now();
        //System.out.println("today:"+today);
        createImgByCompanyId("XCC","C:\\Users\\xsf\\Desktop\\");
    }

    // 依据公司信息生成个性化小程序码,返回小程序码名称
    public static String createImgByCompanyId(String companyId, String dir) {
        // 获取token
        String appid = "wx8b3f3454sdfsdfsdgdfgdf4tr3402c2d7728";
        String appsecret = "c35b5a0b94ea1ece9c0rwerwerwer34wetwetre390468b3efed7";
//        String token = GetToken.getAccessToken(appid, appsecret);
        String token="13_HITBgcSEhPd8YgS0rai9hSYT7kRH6XhNP4lrmTjL3vbzwT_r7AvylrE2K3HN3Ctw9AkwLq56dPx3pNBcEvLHGmqcMU3OKpArMuEFmIewDCzMdBMadF-rkVWtGu4UEvB72vjTb3azDIwhNdcMZTUbAEAHBC";
        // 生成小程序码接口url
        String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN",
                token);
        // 二维码中信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", "pages/index/index");// 你二维码中跳向的页面
        map.put("scene", companyId);// 携带参数
        JSONObject jsonObject = JSONObject.fromObject(map);
        String result = jsonObject.toString();

//        String json = JSONUtils.toJSONString(map);
        String json =jsonObject.toString();
        // 生成二维码
        try {
            CreateImgUtil.httpPostWithJSON(url, json, companyId,dir);
            return companyId;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
