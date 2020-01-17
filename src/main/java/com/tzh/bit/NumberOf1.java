package com.tzh.bit;

import org.junit.Test;

/**
 * @author Brent
 * @title: NumberOf1
 * @projectName Offer
 * @date 2019/9/21 17:58
 * @description: 二进制中1的个数
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * ***考虑 负数
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class NumberOf1 {

    /**
     * 1. 如果最后一位是 1 , 减去 1 之后, 相当于是对最后一位取反, 最后一位之前的值依然不变
     *      0 1 1  =>  3
     *      0 1 0  =>  2 => (3 - 1)
     *      -----
     *      0 1 0  =>  2
     *     消掉一个 1 , count++
     * 2. 如果最后一位是 0 , 减去 1 之后, 从倒数第二位开始, 第一个 1 变为 0 , 从该位到倒数第二位都变 1
     *      1 1 0 0 0 0  =>  58
     *      1 0 1 1 1 1  =>  57 => (58 - 1)
     *      -----------
     *      1 0 0 0 0 0  =>  32
     *      消掉一个 1 , count++
     * 3. 负数问题( -1 )：n & Integer.MAX_VALUE 解决负数问题
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int count = 0;
        // 如果是负数 记录符号位的 1
        if (n < 0) {
            n = n & Integer.MAX_VALUE;
            count++;
        }
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println((-1 & Integer.MAX_VALUE));
    }

}
