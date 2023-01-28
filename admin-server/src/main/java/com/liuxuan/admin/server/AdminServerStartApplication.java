package com.liuxuan.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author: liuxuan
 * @date: 2023-01-28 10:54
 **/
@EnableAdminServer
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AdminServerStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminServerStartApplication.class, args);
    }
}
