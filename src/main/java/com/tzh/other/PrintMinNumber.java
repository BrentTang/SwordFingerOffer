package com.tzh.other;

import java.util.Arrays;

/**
 * @author Brent
 * @title: PrintMinNumber
 * @projectName Offer
 * @date 2019/9/24 9:46
 * @description: 把数组排成最小的数
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class PrintMinNumber {

    /**
     * 通过两两合并的顺序比较大小
     *  * 当ab < ba, a排在b的左边
     *  * 当ab > ba, b排在a的左边
     *  * 当ab = ba, 位置关系随意
     * @param numbers
     * @return
     */
    public String printMinNumber(int [] numbers) {
        if (numbers == null || numbers.length < 1) return "";

        String[] nums = new String[numbers.length];
        for (int i = 0; i < nums.length; i++)
            nums[i] = numbers[i] + "";

        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        StringBuilder res = new StringBuilder();
        for (String s : nums)
            res.append(s);

        return res.toString();
    }

}
