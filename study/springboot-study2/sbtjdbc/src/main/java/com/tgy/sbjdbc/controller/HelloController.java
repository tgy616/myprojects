package com.tgy.sbjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author tanggy
 * @date 2018/6/21
 */
@Controller
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/query")
    public Map<String, Object> map(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
        return list.get(0);
    }
}
