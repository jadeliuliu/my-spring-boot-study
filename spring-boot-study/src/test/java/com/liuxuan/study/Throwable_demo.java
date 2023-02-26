package com.liuxuan.study;

import org.apache.ibatis.session.ResultHandler;

/**
 * @author: liuxuan
 * @date: 2023-02-20 22:22
 **/
public class Throwable_demo {
    static void generate_throwable() {
        generate_throwable();
    }

    public static void main(String[] args) {
        //此种情形下我们要catch Throwable, 以确保异常被打印...
        try {
            final int[] times = { 0 };
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        ++times[0];
                        System.out.println(times[0]);
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread1.start();
            generate_throwable();
        } catch (Throwable e) {
            //若catch的是Exception：
            //因finally中的exit指令，在打印异常前程序就会终止。
            e.printStackTrace();
        } finally {
            System.out.println("end.");
            //如果不exit: 因 thread1 未停止，程序不会终止。
            System.exit(0);
        }
    }
}
