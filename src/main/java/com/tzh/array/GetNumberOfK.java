package com.tzh.array;

import org.junit.Test;

/**
 * @author Brent
 * @title: GetNumberOfK
 * @projectName Offer
 * @date 2019/9/25 8:46
 * @description: 	数字在排序数组中出现的次数
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class GetNumberOfK {

    @Test
    public void test() {
        int[] array = {1,1,3,4,4,4,6,6,7,9,9,9};
        int target = 2;
        System.out.println(getNumberOfK(array, 1));
        /*System.out.println(getNumberOfK(array, 3));
        System.out.println(getNumberOfK(array, 4));
        System.out.println(getNumberOfK(array, 6));
        System.out.println(getNumberOfK(array, 7));
        System.out.println(getNumberOfK(array, 9));*/
    }

    public int getNumberOfK(int [] array , int k) {
        if (array == null || array.length < 1) return 0;

        int first = findFirst(array, k);
        System.out.println("first: " + first);
        if (first == -1) return 0;
        int last = findLast(array, k);
        System.out.println("last: " + last);
        return last - first + 1;
    }

    public int findFirst(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + ((end - start) >> 1);
            if (array[mid] < k)
                start = mid;
            else
                end = mid;
        }
        if (array[start] == k) return start;
        if (array[end] == k) return end;
        return -1;
    }

    public int findLast(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + ((end - start) >> 1);
            if (array[mid] > k)
                end = mid;
            else
                start = mid;
        }
        if (array[end] == k) return end;
        if (array[start] == k) return start;
        return -1;
    }

}
