package com.liuxuan.service;

import com.liuxuan.StartApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: com.liuxuan
 * @date: 2022-12-25 16:32
 **/
@SpringBootTest(classes = StartApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testPrint() {
        userService.printUser();
    }

    @Test
    public void testRedisSet() {
        redisTemplate.boundValueOps("name").set("liu");
    }

    @Test
    public void testRedisGet() {
        Object o = redisTemplate.boundValueOps("name").get();
        System.out.println(o);
    }
}
