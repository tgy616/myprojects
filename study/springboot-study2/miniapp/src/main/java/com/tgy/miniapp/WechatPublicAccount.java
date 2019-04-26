package com.tgy.miniapp;

import java.util.TreeMap;

/**
 * @author tanggy
 * @date 2018/10/9
 */
public class WechatPublicAccount {
    public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

    /**
     * 获取授权凭证token
     * @param key 应用appid
     * @param secret 应用密匙
     *  @return json格式的字符串
     */
    public static String getAccessToken(String appid, String secret) {
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("grant_type", "client_credential");
        map.put("appid", appid);
        map.put("secret", secret);
        String json = HttpReqUtil.HttpDefaultExecute(SystemConfig.GET_METHOD, WechatConfig.GET_ACCESS_TOKEN_URL, map, "");
        String result = null;
        AccessToken accessToken = JsonUtil.fromJsonString(json, AccessToken.class);
        if (accessToken != null) {
            result = accessToken.getAccess_token();
        }
        return result;
    }

}
