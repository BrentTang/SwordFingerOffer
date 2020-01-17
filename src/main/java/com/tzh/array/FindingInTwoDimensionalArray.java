package com.tzh.array;

import org.junit.Test;

/**
 * @author Brent
 * @title: FindingInTwoDimensionalArray
 * @projectName Offer
 * @date 2019/9/21 8:35
 * @description: 二维数组中的查找
 *
 *  在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 *  每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 *  判断数组中是否含有该整数。
 *
 *  时间限制：1秒 空间限制：32768K
 */
public class FindingInTwoDimensionalArray {

    public boolean Find(int target, int [][] array) {
        if (array == null || array.length < 1 || array[0].length < 1 || target < array[0][0]) return false;

        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (target < array[row][col]) {
                col--;
            } else if (target > array[row][col]) {
                row++;
            } else
                return true;
        }
        return false;
    }

    @Test
    public void test() {
        int[][] array = {{1,2,3,4,5,6,7},
                        {8,9,10,10,12,13,14},
                        {15,16,17,18,19,20,21}
                        };
        int target = 11;
        System.out.println(Find(target, array));
    }
}
