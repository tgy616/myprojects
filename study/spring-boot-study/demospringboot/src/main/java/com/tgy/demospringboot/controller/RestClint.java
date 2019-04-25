package com.tgy.demospringboot.controller;

import com.tgy.demospringboot.dao.User;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author tanggy
 * @date 2018/5/18
 */
public class RestClint {

    public static void main(String[] args) {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpClient httpClient = httpClientBuilder.build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(factory);
        //String content=restTemplate.getForObject("http://localhost:8080/json/user",String.class);
        //User user=restTemplate.getForObject("http://localhost:8080/json/user",User.class);
        User user = restTemplate.getForObject("http://localhost:8080/xml/user", User.class);
        //调试才能看到user的内容
        System.out.println(user.toString());
    }
}
