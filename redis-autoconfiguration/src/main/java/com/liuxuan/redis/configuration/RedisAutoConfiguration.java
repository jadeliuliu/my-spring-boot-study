package com.liuxuan.redis.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @author: liuxuan
 * @date: 2023-01-03 22:56
 **/
@Configuration
@EnableConfigurationProperties(RedisProperties.class) //RedisProperties被spring识别，创建bean
@ConditionalOnClass(Jedis.class)  //疑问：创建之前不是没这个Bean吗
public class RedisAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "jedis")  //已经定义了就不定义
    public Jedis getJedisBean(RedisProperties redisProperties) {
        System.out.println("RedisAutoConfiguration...");
        return new Jedis(redisProperties.getIp(), redisProperties.getPort());
    }
}
