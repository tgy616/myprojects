package com.tgy.demospringboot.controller;

import com.tgy.demospringboot.dao.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanggy
 * @date 2018/5/18
 */
@RestController
public class XMLRestController {

    @GetMapping(path = "/xml/user",
//            consumes = {
//            MediaType.TEXT_HTML_VALUE,"application/xml",
//            MediaType.APPLICATION_ATOM_XML_VALUE},
            produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public User user() {
        User user = new User();
        user.setName("xml");
        user.setAge(18);
        return user;
    }


}
