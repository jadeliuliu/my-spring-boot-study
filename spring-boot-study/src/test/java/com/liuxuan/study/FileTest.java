package com.liuxuan.study;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author: liuxuan
 * @date: 2023-02-18 16:05
 **/
public class FileTest {

    @Test
    public void testByte() {
        byte[] data = "hello world".getBytes();
        //apache里io的IOUtils需要commons-io包
        String s1 = IOUtils.toString(data, "utf-8");
        String s2 = new String(data);
        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void testPath() throws IOException {
        Path path1 = Paths.get("C:", "path", "to", "nowhere", "NoFile.txt");
        System.out.println(path1); //C:/path/to/nowhere/NoFile.txt
        Path path2 = Paths.get("C:/path/to/nowhere/NoFile.txt");
        System.out.println(path2); //C:/path/to/nowhere/NoFile.txt
        URI uri = path2.toUri();  //转换为URI对象，可以用于构建web资源的绝对uri
        System.out.println(uri); //file:///Users/liuxuan/MyProject/mypro/spring-boot-demo/spring-boot-study/C:/path/to/nowhere/NoFile.txt
        Path path3 = Paths.get(uri);
        System.out.println(path3);

        // 返回表示此路径的绝对路径的Path对象
        Path p = Paths.get("FileTest.java").toAbsolutePath();  //相对于当前项目目录
        System.out.println(p); ///Users/liuxuan/MyProject/mypro/spring-boot-demo/spring-boot-study/FileTest.java
        // 返回表示此路径的真实路径的Path对象，也即是带上盘符（根路径）
        Path p2 = Paths.get("/Users/liuxuan/Downloads/test").toRealPath();
        // getNameCount() 返回路径中的名称元素的数量
        for(int i = 0; i < p.getNameCount(); i++) {
            // 返回此路径的名称元素作为 Path对象
            System.out.println(p.getName(i));
        }
        // 测试路径是否以给定的路径结束，这里会输出 end with '.java':false
        System.out.println("ends with '.java': " + p.endsWith(".java"));
        // Path 也实现了 iterable 接口，会对路径中的名称元素进行遍历
        for(Path pp : p) {
            System.out.println(pp);
        }
        // getRoot() 返回此路径的根路径作为Path对象，为null则该路径不具有根
        // startsWith() 效果和 endsWith() 相似
        // 这里会输出 Starts with C:\ true
        System.out.println("Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));

        // 使用..可以跳转到上一级路径，但必须使用normalize()方法
        // 假设当前路径为/Users/liuxuan/MyProject/mypro/spring-boot-demo/spring-boot-study/FileTest.java
        Path base = Paths.get("..", "..", "..").toAbsolutePath().normalize();
        System.out.println(base); ///Users/liuxuan/MyProject
        // 构造此路径和给定路径之间的相对路径
        Path p4 = base.relativize(p);
        System.out.println(p4);
        // 使用resolve构造路径
        // 此时路径为C:\Users\Bruce\Documents\GitHub\string
        Path convoluted = p.getParent().resolve("string");
        System.out.println(convoluted);

    }

    @Test
    public void testFiles() throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get("/Users/liuxuan/Downloads/test/cal.sh"));
        System.out.println(new String(fileBytes));
    }

    @Test
    public void testFilesDir() throws IOException {
        String path = "/Users/liuxuan/Downloads/";
        File fileDir = new File(path);
        if (!fileDir.exists() || !fileDir.isDirectory()) {
            throw new RuntimeException("不是文件夹");
        }
        String[] fileList = fileDir.list();
        int count = 0;
        for (String file : fileList) {
            if (new File(path + file).isDirectory()) {
                count ++;
            }
        }
        File[] files = fileDir.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
        System.out.println(count);

        Path path1 = Paths.get("/Users/liuxuan/Downloads/");
        if (!Files.exists(path1) || !Files.isDirectory(path1)) {
            throw new RuntimeException("不是文件夹");
        }
        long dirCount = Files.list(path1).filter(Files :: isDirectory).count();
        System.out.println(dirCount);
    }

}
