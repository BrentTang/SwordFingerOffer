package com.tzh.array;

import org.junit.Test;

/**
 * @author Brent
 * @title: FindGreatestSumOfSubArray
 * @projectName Offer
 * @date 2019/9/23 15:30
 * @description: 连续子数组的最大和
 *
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class FindGreatestSumOfSubArray {

    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length < 1) return 0;

        int start = 0;
        int end = array.length - 1;

        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];

        int max = sum;
        while (start < end) {
            if (array[start] < array[end]) {
                sum -= array[start];
                start++;
            } else {
                sum -= array[end];
                end--;
            }
            //System.out.println("(" + start + ", " + end + ") = " + sum);
            max = Math.max(max, sum);
        }

        return max;
    }

    @Test
    public void test() {
        int[] array = {1,-2,3, -100, 200,-10,-400,7,2,-5};
        System.out.println(findGreatestSumOfSubArray(array));
    }

}
