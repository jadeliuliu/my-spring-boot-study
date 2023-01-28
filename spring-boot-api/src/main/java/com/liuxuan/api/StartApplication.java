package com.liuxuan.api;

import com.liuxuan.condition.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author: liuxuan
 * @date: 2022-12-30 18:29
 * 想获取另一个包下的bean
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@ComponentScan("com.liuxuan.condition")
//@Import(UserConfig.class)
//@EnableUser
//@Import(User.class)
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegistrar.class)
public class StartApplication {
    public static void main(String[] args) {
        // 启动springboot应用，获取spring的ioc容器
        ConfigurableApplicationContext context = SpringApplication.run(StartApplication.class, args);
        Jedis jedis = context.getBean(Jedis.class);
        System.out.println(jedis);

        jedis.set("hello", "hi");
        System.out.println(jedis.get("hello"));

        // 获取bean
        Object user = context.getBean(User.class);
        System.out.println(user);

        Map<String, User> map = context.getBeansOfType(User.class);
        System.out.println(map);
    }
}