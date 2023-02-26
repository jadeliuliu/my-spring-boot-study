package com.liuxuan.study;

import org.junit.jupiter.api.Test;

/**
 * @author: liuxuan
 * @date: 2023-02-23 22:41
 **/
public class StringTest {
    @Test
    public void test1() {
        Double d = null;
        System.out.println(String.valueOf(d));
        double d1 = 1.2;
        String s1 = String.valueOf(d);
    }
}
