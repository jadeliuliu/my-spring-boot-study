package com.liuxuan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: com.liuxuan
 * @date: 2022-12-22 23:28
 **/
@RestController
@RequestMapping("/h")
public class HelloController {

    @Value("${person.name}")
    private String name;

    @Value("${person.address[0]}")
    private String address;

    @Autowired
    private Environment env;

    @RequestMapping("/hello2")
    public String hello2() {
        return name + " " + address + " " + env.getProperty("person.name");
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello!world!!!";
    }
}
