package com.tgy.sbwebjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tanggy
 * @date 2018/6/20
 */
@Controller
public class HelloController {
    @GetMapping("/abc")
    public String hello(Model model){
        model.addAttribute("msg","hello jsp!!");
        return "success";
    }

}
