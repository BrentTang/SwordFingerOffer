package com.tzh.other;


import org.junit.Test;

import java.util.Arrays;

/**
 * @author Brent
 * @title: ReOrderArray
 * @projectName Offer
 * @date 2019/9/21 18:45
 * @description: 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class ReOrderArray {

    public void reOrderArray(int [] array) {
        if (array == null || array.length < 2) return;

        int oddIndex = -1;
        int evenIndex = -1;
        // 找第一个偶数
        while (++evenIndex < array.length && (array[evenIndex] & 1) == 1);
        oddIndex = evenIndex;
        while (oddIndex < array.length && evenIndex < array.length) {
            // 找一个奇数
            while (++oddIndex < array.length && (array[oddIndex] & 1) == 0);
            if (oddIndex < array.length) {
                lastToFirst(array, evenIndex, oddIndex);
                evenIndex++;
            }
        }
    }

    /**
     * 将第end个元素放到start
     * @param array
     * @param first
     * @param last
     */
    public void lastToFirst(int[] array, int first, int last) {
        int temp = array[last];
        for (int i = last - 1; i >= first; i--) {
            array[i + 1] = array[i];
        }
        array[first] = temp;
    }

    @Test
    public void test() {
        //int[] array = {2,4,6,1,3,5,7};
        int[] array = {1,2,3,4,5,6,7,8};

        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

}
