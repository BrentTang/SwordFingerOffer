package com.tzh.bit;

import org.junit.Test;

/**
 * @author Brent
 * @title: Add
 * @projectName Offer
 * @date 2019/9/26 10:57
 * @description: 	不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class Add {

    public int add(int num1,int num2) {
        // 当没有产生进位就结束
        while (num2 != 0) {
            // 不考虑进位  相同为 0 不同为 1
            int temp = num1 ^ num2;
            // 考虑进位
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    @Test
    public void test() {
        System.out.println(add(-17, -8));
    }

}
