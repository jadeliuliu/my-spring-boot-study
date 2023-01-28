package com.liuxuan.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: liuxuan
 * @date: 2023-01-06 09:27
 **/
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner run...");
        System.out.println("MyCommandLineRunner args:" + Arrays.asList(args));

    }
}
