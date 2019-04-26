package com.tgy.miniapp;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import sun.applet.Main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanggy
 * @date 2018/8/28
 */
public class CreatLimtCodePic {
    public static Map getminiqrQr(String accessToken) {
        String sence="s=9527&d=1";
        RestTemplate rest = new RestTemplate();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String url = "https://api.weixin.qq.com/wxa/getwxacode?access_token="+accessToken;
            Map<String,Object> param = new HashMap<>();
            param.put("page", "pages/index/index/");
            param.put("width", 430);
            param.put("auto_color", false);
            Map<String,Object> line_color = new HashMap<>();
            line_color.put("r", 0);
            line_color.put("g", 0);
            line_color.put("b", 0);
            param.put("line_color", line_color);
            System.out.println("调用生成微信URL接口传参:" + param);
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            HttpEntity requestEntity = new HttpEntity(param, headers);
            ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class, new Object[0]);
            System.out.println("调用小程序生成微信永久小程序码URL接口返回结果:" + entity.getBody());
            byte[] result = entity.getBody();
            System.out.println(Base64.encodeBase64String(result));
            inputStream = new ByteArrayInputStream(result);

            File file = new File("C:\\Users\\xsf\\Desktop\\11.png");
            if (!file.exists()){
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.flush();
        } catch (Exception e) {
           System.err.println("调用小程序生成微信永久小程序码URL接口异常");
           System.out.println(e);
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String tocken="13_jBxOaP10_iLgx5JBVqtrzXiCJhVu96sIVw8r6zqHgOk_sGCiUJ1cOjOwBox_Hk0L1cJbMliSJWufyWi3oIxUGU4Z2QyUzdqgIsZIIYGP3yOt5WO32KLTHxHn5cBORm-3159Z-CcUyUdPWRqpNKBiACAROF";
        String sence="s=9527&d=1";
        getminiqrQr(tocken);
    }
}
