package com.liuxuan.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: liuxuan
 * @date: 2023-01-06 09:28
 **/
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner run...");
        System.out.println("MyApplicationRunner args:" + Arrays.asList(args.getSourceArgs()));
    }
}
