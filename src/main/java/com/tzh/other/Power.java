package com.tzh.other;

/**
 * @author Brent
 * @title: Power
 * @projectName Offer
 * @date 2019/9/21 18:37
 * @description: 数值的整数次方
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class Power {

    public double power(double base, int exponent) {

        return base == 1 || base == 0 ? base : Math.pow(base, exponent);
    }

}
