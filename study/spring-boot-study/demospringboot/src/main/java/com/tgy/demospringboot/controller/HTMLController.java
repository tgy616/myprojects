package com.tgy.demospringboot.controller;

import com.tgy.demospringboot.service.IndexService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tanggy
 * @date 2018/5/16
 */
//@RestController=@Controller+@ResponseBody
@RestController
public class HTMLController {
    @Autowired
    private IndexService indexService;

    @RequestMapping("/index")
    public String showHello() {
        return indexService.showHello();
    }

    @RequestMapping("/rest")
    //@ResponseBody
    public Map<String, Object> rest() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("1", "A");
        data.put("2", 2);
        return data;
    }

    //@RequestMapping和GetMapping 不能同用
    //@RequestMapping(value = {"/html/demo","/html/demo2"},method = {RequestMethod.GET})
    @GetMapping(path = {"/html/demo3"})
    @PostMapping(path = {"/html/demo4"})
    //@ResponseBody
    public String htmlCode() {
        return "<html><body>hello world!!!<br/>this is web page!!</body></html>";
    }

    @GetMapping("/html/demo/{message}")
    public String htmlPathVariable(@PathVariable String message) {
        return "<html><body>hello world!!!<br/>this is web page!!<p/>" + message + "</body></html>";
    }

    @GetMapping("/html/demo/param")
    public String htmlParam(@RequestParam(value = "p", required = false, defaultValue = "Empty") String param,
                            HttpServletRequest request,
                            @RequestParam(value = "age", required = false, defaultValue = "0") String age) {
        String param2 = request.getParameter("param2");
        return "<html><body>Request Paramter value:" + param +
                ",parem2 value:" + param2 +
                ",age value:" + age + "</body></html>";
    }

    @GetMapping("/html/demo/header")
    public String htmlHeader(@RequestHeader(value = "Accept") String acceptHeader) {
        return "<html><body>Request Accept value:" + acceptHeader + "</body></html>";
    }

    @GetMapping("/html/demo/response/entity")
    public ResponseEntity<String> htmlResponseEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.put("Myheader", Arrays.asList("MyheaderValue"));
        ResponseEntity responseEntity = new ResponseEntity("<html><body>ResponseEntity</body></html>", httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

}
