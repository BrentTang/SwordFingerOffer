package com.tzh.string;

import org.junit.Test;

/**
 * @author Brent
 * @title: Numeric
 * @projectName Offer
 * @date 2019/10/1 15:27
 * @description: 	表示数值的字符串
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class Numeric {

    /**
     * 数字的基本格式为：(A.B E/e A) ,按顺序进行判断
     * A代表带符号整数，B代表不带符号整数
     * 小心：时刻要注意数组越界问题！
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        int len = str.length;
        int cur = integerRange(str, 0);

        if (cur != -1 && cur < len && str[cur] == '.')
            cur = unsignedIntegerRange(str, cur + 1);

        if (cur != -1 && cur < len && (str[cur] == 'E' || str[cur] == 'e') && cur < len - 1)
            cur = integerRange(str, cur + 1);

        return cur == len && cur != -1;
    }

    /**
     * 判断是否是带符号的整数
     * 遇到   . 或 E/e 返回
     * @param str
     * @param start
     * @return
     */
    public int integerRange(char[] str, int start) {
        if (start >= str.length) return start;
        if (str[start] != '+' && str[start] != '-' && str[start] < '0' && str[start] > '9')
            return start;
        int cur = unsignedIntegerRange(str, start + 1);

        if (str[start] == '+' || str[start] == '-')
            return cur == -1 ? -1 : cur;
        else
            return cur == -1 ? start + 1 : cur;
    }

    /**
     *
     * @param str
     * @param start
     * @return
     */
    public int unsignedIntegerRange(char[] str, int start) {
        int i = start;
        for (; i < str.length && str[i] >= '0' && str[i] <= '9'; i++) ;
        return i - start > 0 ? i : -1;
    }

    @Test
    public void test() {

        /*System.out.println(isNumeric("+100".toCharArray()));
        System.out.println(isNumeric("5e2".toCharArray()));
        System.out.println(isNumeric("-123".toCharArray()));
        System.out.println(isNumeric("3.1416".toCharArray()));
        System.out.println(isNumeric("-1E-16".toCharArray()));

        System.out.println("==============================");

        System.out.println(isNumeric("12e".toCharArray()));
        System.out.println(isNumeric("12.".toCharArray()));
        System.out.println(isNumeric("1a3.14".toCharArray()));
        System.out.println(isNumeric("1.2.3".toCharArray()));
        System.out.println(isNumeric("+-5".toCharArray()));
        System.out.println(isNumeric("12e+4.3".toCharArray()));*/

        System.out.println(isNumeric("-.123".toCharArray()));
    }

}
