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
@RequestMapping("/h1")
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello!world!!!";
    }
}
