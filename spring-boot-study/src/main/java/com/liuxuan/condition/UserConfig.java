package com.liuxuan.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuxuan
 * @date: 2022-12-26 09:25
 **/
@Configuration
public class UserConfig {
    @Bean
//    @Conditional(ClassCondition.class)
    @ConditionOnClass("redis.clients.jedis.Jedis")
    public User user() {
        return new User();
    }
}
