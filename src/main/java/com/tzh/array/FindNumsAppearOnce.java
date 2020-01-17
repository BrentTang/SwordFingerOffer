package com.tzh.array;

import org.junit.Test;

/**
 * @author Brent
 * @title: FindNumsAppearOnce
 * @projectName Offer
 * @date 2019/9/25 9:49
 * @description: 	数组中只出现一次的数字
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 *  时间限制：1秒 空间限制：32768K
 */
// num1,num2分别为长度为1的数组。传出参数
// 将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {

    /**
     * 若对原数组从头到尾的进行异或，则最后得到的结果就是两个只出现一次的数字的异或运算结果。
     * 这个结果的二进制表示中，至少有一位为1，因为这两个数不相同。该位记为从最低位开始计数的第n位。
     *
     * 则分组的标准定为从最低位开始计数的第n位是否为1。因为出现两次的同一个数字，各个位数上都是相同的，
     * 所以一定被分到同一个子数组中，且每个子数组中只包含一个出现一次的数字。
     *
     * 例如：数组元素为2,4,3,6,3,2,5,5，异或的结果为0010，
     * 也就是倒数第二位为1，也就是倒数第二位为标记位来进行拆分，
     * 那么第一个子数组就为{2,3,6,3,2}，他们的倒数第二位为1，
     * 第二个子数组为{4,5,5}倒数第二位为0，对这两个子数组分别再异或，最终找到6和4。
     * @param array
     * @param num1
     * @param num2
     */
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = 0;
        // 1. 得到两个不同数的异或结果
        for (int i : array)
            temp = temp ^ i;

        if (temp == 0)
            return;
        // 记录temp(两个不相同数的异或结果的1的最低为的索引)
        int index = 0;
        // 2. 找到 两个不相同数异或结果 的1的最低为索引
        //      按照该索引位上是否为 1, 将数组划分为两段, 两个不相同的数也会被分别划分到的这两段数组
        while ((temp & 1) == 0) {
            temp >>>= 1;
            index++;
        }

        // 3. 划分后就可以直接异或了
        // i >>> index & 1 判断是 1 数组还是 2 数组
        for (int i : array)
            if ((i >>> index & 1) != 0)
                num1[0] ^= i;
            else
                num2[0] ^= i;
    }

    @Test
    public void test() {
        int[] array = {2,4,3,6,3,2,5,5};
        int[] num1 = {0};
        int[] num2 = {0};
        findNumsAppearOnce(array, num1, num2);
        System.out.println("num1: " + num1[0] + ", num2: " + num2[0]);

        /*int  x=-3;  float  y=10.0f;
        System.out.println(y%x);*/
    }

}
