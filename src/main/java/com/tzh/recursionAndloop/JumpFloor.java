package com.tzh.recursionAndloop;

/**
 * @author Brent
 * @title: JumpFloor
 * @projectName Offer
 * @date 2019/9/21 17:25
 * @description: 	跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 0    0                                                   f(0)=0
 * 1    1                                                   f(1)=1
 * 2    2*1 1*2                                             f(2)=2
 * 3    3*1 1*2+1*1 1*1+1*2                                 f(3)=3
 * 4    4*1 1*2+1*2 1*2+1*1+1*1 1*1+1*1+1*2 1*1+1*2+1*1     f(4)=5
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class JumpFloor {

    public int jumpFloor(int target) {
        if (target < 3) return target;

        int n1 = 1;
        int n2 = 2;
        int cur = 1;
        for (int i = 3; i <= target; i++) {
            cur = n1 + n2;
            n1 = n2;
            n2 = cur;
        }
        return cur;
    }

}
