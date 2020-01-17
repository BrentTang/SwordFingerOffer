package com.tzh.string;

import org.junit.Test;

/**
 * @author Brent
 * @title: StringToInt
 * @projectName Offer
 * @date 2019/9/26 11:07
 * @description: 	把字符串转换成整数
 *
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 输入
 *  +2147483647
 * 输出
 *  2147483647
 * 输入
 *     1a33
 * 输出
 *     0
 */
public class StringToInt {

    public int strToInt(String str) {
        if (str == null || str.length() < 1) return 0;

        int flag = 1;
        int cur = 0;
        if (str.charAt(0) == '-') {
            cur = 1;
            flag = -1;
        } else if (str.charAt(0) == '+') cur = 1;
        else if (str.charAt(0) < '0' && str.charAt(0) > '9') return 0;

        int res = 0;
        for (; cur < str.length(); cur++) {
            if (str.charAt(cur) < '0' || str.charAt(cur) > '9')
                return 0;
            res = res * 10 + (str.charAt(cur) - '0');
        }

        return res * flag;
    }

    @Test
    public void test() {
        String str = "147483647";
        System.out.println(strToInt(str));
    }

}
