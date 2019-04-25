package com.tgy.servletspringboot.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tanggy
 * @date 2018/5/22
 */
@Controller
public class JspDemoConroller {
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("message","tgy welcome </p> this is a springboot jsp!!");
        return "index";
    }
}
