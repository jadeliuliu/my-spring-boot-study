package com.liuxuan.admin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author: liuxuan
 * @date: 2023-01-28 16:04
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AdminClientStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminClientStartApplication.class, args);
    }
}
