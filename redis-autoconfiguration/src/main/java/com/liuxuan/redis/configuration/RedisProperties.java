package com.liuxuan.redis.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: liuxuan
 * @date: 2023-01-03 22:59
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "redis") //与配置文件中对应
public class RedisProperties {
    private String ip = "localhost"; //没提供时给默认值
    private Integer port = 6379;
}
