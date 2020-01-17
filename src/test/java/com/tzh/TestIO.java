package com.tzh;

import org.junit.Test;

import java.io.*;

/**
 * @author Brent
 * @title: TestIO
 * @projectName Offer
 * @date 2019/9/26 18:27
 * @description: TODO
 */
public class TestIO {

    @Test
    public void test() throws IOException {
        System.out.println();
        File file = new File("D:\\*test.txt");
        // 路劲下没有文件时，调用open()方法时创建

        FileOutputStream o = new FileOutputStream(file, true);

        System.out.println();
        //o.write(10);
    }

}
