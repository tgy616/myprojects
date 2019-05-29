package com.tgy.springbootsecure.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * SecurityController
 *
 * @author DragonSwimDiving
 * @program springbootsecure
 * @Date 2019-05-27 15:26
 **/
@Controller
public class SecurityController {

    @GetMapping("")
    public String index(){

        return "index";
    }
    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @GetMapping("/xss")
    public String xss(Model model){
        //JS Code 需要被 Escape
        model.addAttribute("jsCode","<script>alert('XSS Attack!!')</script>");
        //HTML Code 不需要被 Escape(unescape)
        model.addAttribute("htmlCode","<span>hello world</span>");
        return "xss";
    }
}
