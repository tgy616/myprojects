package com.tgy.springbootsecure.controllor;

import org.springframework.stereotype.Controller;
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

    @GetMapping("/index")
    public String index(){

        return "index";
    }
    @GetMapping("/login")
    public String login(){

        return "login";
    }
}
