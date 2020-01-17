package com.tzh.searchAndsort;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Brent
 * @title: minNumberInRotateArray
 * @projectName Offer
 * @date 2019/9/21 15:18
 * @description: 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 时间限制：3秒 空间限制：32768K
 */
public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length < 1) return 0;

        int low = 0;
        int high = array.length - 1;
        int mid = low + ((high - low) >>> 1);
        while (low < high) {
            // {3,4,5,6,7,1,2}
            if (array[low] < array[mid] && array[mid] > array[high]) {
                if (mid + 1 < array.length && array[mid + 1] < array[mid])
                    return array[mid + 1];
                low = mid + 1;
                mid = low + ((high - low) >>> 1);
            }

            // {6,7,1,2,3,4,5} or {5,6,7,1,2,3,4}
            if (array[low] > array[mid] && array[mid] < array[high]) {
                if ((mid + 1 < array.length && array[mid + 1] < array[mid]) || (mid - 1 >= 0 && array[mid - 1] > array[mid]))
                    return array[mid];
                high = mid - 1;
                mid = low + ((high - low) >>> 1);
            }
        }
        return 0;
    }

    public int hepler(int[] array) {
        if (array == null || array.length < 1) return 0;

        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length && array[i] > array[i + 1])
                return array[i + 1];
        }
        return 0;
    }

    @Test
    public void test() {
        int[] array = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        //int[] array = {6,7,1,2,3,4,5};
        //int[] array = {3,4,5,6,7,1,2};
        //int[] array = {5,6,7,1,2,3,4};
        System.out.println(minNumberInRotateArray(array));
    }

}
