package com.tzh.array;

import org.junit.Test;

/**
 * @author Brent
 * @title: InversePairs
 * @projectName Offer
 * @date 2019/9/24 10:47
 * @description: 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 输入描述:
 *  题目保证输入的数组中没有的相同的数字
 *  数据范围：
 * 	    对于%50的数据,size<=10^4
 * 	    对于%75的数据,size<=10^5
 * 	    对于%100的数据,size<=2*10^5
 *
 * 输入: 1,2,3,4,5,6,7,0
 *
 * 输出: 7
 *
 * 时间限制：2秒 空间限制：32768K
 */
public class InversePairs {

    int count = 0;
    public int inversePairs(int [] array) {
        if (array != null && array.length < 1) return 0;

        mergeSort(array, 0, array.length - 1, new int[array.length]);
        return count;
    }

    public void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    public void merge(int[] array, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int tempIndex = 0;
        while (l <= mid && r <= right) {
            if (array[l] < array[r]) {
                temp[tempIndex++] = array[l++];
            } else {
                count += (mid - l + 1);
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
                temp[tempIndex++] = array[r++];
            }
        }

        while (l <= mid) {
            temp[tempIndex++] = array[l++];
        }

        while (r <= right) {
            temp[tempIndex++] = array[r++];
        }

        tempIndex = 0;
        for (int i = left; i <= right; i++) {
            array[i] = temp[tempIndex++];
        }
    }

    @Test
    public void test() {
        //int[] array = {1,2,3,4,5,6,7,0};
        int[] array = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407,
                416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965,
                516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233,
                144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882,
                576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983,
                583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870,
                259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64,
                266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575 };
        System.out.println(inversePairs(array));
    }

}
