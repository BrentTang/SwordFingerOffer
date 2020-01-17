package com.tzh.recursionAndloop;

/**
 * @author Brent
 * @title: JumpFloor2
 * @projectName Offer
 * @date 2019/9/21 17:39
 * @description: 变态跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 *  f(1)    1
 *  f(2)    2
 *  f(3)    4
 *  f(4)    8
 *  f(5)    16
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class JumpFloor2 {

    public int jumpFloorII(int target) {
        if (target < 3) return target;
        int count = 2;
        for (int i = 3; i <= target; i++) {
            count *= 2;
        }
        return count;
    }

}
