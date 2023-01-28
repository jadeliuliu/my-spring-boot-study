package com.liuxuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: com.liuxuan
 * @date: 2022-12-22 23:38
 **/
@SpringBootApplication
public class StartApplication {
    public static void main(String[] args) {
        // 启动springboot应用，获取spring的ioc容器
        ConfigurableApplicationContext context = SpringApplication.run(StartApplication.class, args);

        // 获取bean
        Object user = context.getBean("user");
        System.out.println(user);
    }
}