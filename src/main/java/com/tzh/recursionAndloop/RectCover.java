package com.tzh.recursionAndloop;

/**
 * @author Brent
 * @title: RectCover
 * @projectName Offer
 * @date 2019/9/21 17:47
 * @description: 矩形覆盖
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * f(1)     1
 * f(2)     2
 * f(3)     3
 * f(4)     5
 * 时间限制：1秒 空间限制：32768K
 */
public class RectCover {

    public int rectCover(int target) {
        if (target < 3) return target;

        int n1 = 1;
        int n2 = 2;
        int cur = 0;
        for (int i = 3; i <= target; i++) {
            cur = n1 + n2;
            n1 = n2;
            n2 = cur;
        }
        return cur;
    }

}
