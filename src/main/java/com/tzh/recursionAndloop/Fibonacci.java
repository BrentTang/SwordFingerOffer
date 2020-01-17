package com.tzh.recursionAndloop;

import org.junit.Test;

/**
 * @author Brent
 * @title: Fibonacci
 * @projectName Offer
 * @date 2019/9/21 17:13
 * @description: 斐波那契数列
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class Fibonacci {

    public int fibonacci(int n) {
        int before = 0;
        int after = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = before + after;
            before = after;
            after = result;
        }
        return n == 1 ? after : result;
    }

    @Test
    public void test() {
        System.out.println(fibonacci(4));
    }

}
