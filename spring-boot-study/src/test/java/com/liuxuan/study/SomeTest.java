package com.liuxuan.study;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: liuxuan
 * @date: 2023-02-18 16:16
 **/
public class SomeTest {

    @Test
    public void testInetAdress() throws UnknownHostException {
        String localIP = InetAddress.getLocalHost().getHostAddress();
        System.out.println(localIP);
    }

    @Test
    public void testClass() {
        String className1 = SomeTest.class.getName();
        System.out.println(className1); //com.liuxuan.study.SomeTest
        String className2 = SomeTest.class.getSimpleName();
        System.out.println(className2); //SomeTest
    }
}
