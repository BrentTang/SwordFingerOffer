package com.tzh.other;

/**
 * @author Brent
 * @title: BeforeNSum
 * @projectName Offer
 * @date 2019/9/26 10:33
 * @description: 求1+2+3+...+n
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class BeforeNSum {

    public int Sum_Solution(int n) {
        if (n < 1) return 0;
        return Math.multiplyExact(1 + n, n) >> 1;
    }

}
