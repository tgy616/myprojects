package com.tgy.miniapp;

import net.sf.json.JSONObject;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author tanggy
 * @date 2018/8/4
 */
public class GetToken {
    //获取token的接口地址
    String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?" + "grant_type=client_credential&appid=wx33950d62340399dc&secret=6e7597770a15bd28a1dc34f54b73a913";
    /**
     * 获取access_token
     *
     * @param appid
     * @param appsecret
     * @return
     */
    public  String getAccessToken(String appid, String appsecret) {
        try {
            String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
            JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
            return jsonObject.getString("access_token");
        } catch (Exception e) {
            return "errer";
        }
    }

    /**
     *
     * @Title: httpsRequest
     * @Description: 发送请求,返回JSONObject对象
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     * @throws Exception
     */
    public JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) throws Exception {
        JSONObject jsonObject = null;
        try {
            // 使用自定义的信任管理器
            TrustManager[] tm = { new X509TrustManager() {
                /**
                 * 检查客户端证书
                 */
                @Override
                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }

                /**
                 * 检查服务器端证书
                 */
                @Override
                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }

                /**
                 * 返回受信任的X509证书数组
                 */
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

            } };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            // 建立连接
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 设置请求方式
            conn.setRequestMethod(requestMethod);
            // 当outputStr不为null时,向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 获取输入流
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 读取响应内容
            StringBuffer buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 关闭资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (Exception e) {
            throw new Exception("请求/解析失败");
        }
        return jsonObject;
    }

}
