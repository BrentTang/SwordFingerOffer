package com.tzh.array;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Brent
 * @title: printMatrix
 * @projectName Offer
 * @date 2019/9/22 10:10
 * @description: 顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 *              1   2   3   4
 *              5   6   7   8
 *              9   10  11  12
 *              13  14  15  16
 * 则依次打印出数字
 *      1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        // 打印方向
        int direct = 0;
        // 矩阵元素个数
        int count = 0;
        // 剩余可打印的行数
        int maxRow = matrix.length;
        // 剩余可打印的列数
        int maxCol = matrix[0].length;

        // 即将被访问的元素行号
        int curRow = 0;
        // 即将被访问的元素列号
        int curCol = 0;
        while (count < matrix.length * matrix[0].length) {
            switch (direct) {
                case 0: // 向右
                    for (int step = maxCol; step > 0; step--, curCol++, count++)
                        res.add(matrix[curRow][curCol]);
                    // 向右打印完就少了一行
                    maxRow--;
                    // 循环完了curCol多加了一次
                    curCol--;
                    // 指向下一次打印的方向的第一个
                    curRow++;
                    // 下一次的方向
                    direct = 1;
                    break;
                case 1: // 向下
                    for (int step = maxRow; step > 0; step--, curRow++, count++)
                        res.add(matrix[curRow][curCol]);
                    maxCol--;
                    curRow--;
                    curCol--;
                    direct = 2;
                    break;
                case 2: // 向左
                    for (int step = maxCol; step > 0; step--, curCol--, count++)
                        res.add(matrix[curRow][curCol]);
                    maxRow--;
                    curCol++;
                    curRow--;
                    direct = 3;
                    break;
                case 3: // 像上
                    for (int step = maxRow; step > 0; step--, curRow--, count++)
                        res.add(matrix[curRow][curCol]);
                    maxCol--;
                    curRow++;
                    curCol++;
                    direct = 0;
                    break;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int [][] matrix = {
                {1,2,3,4}
        };
        ArrayList<Integer> list = printMatrix(matrix);
        System.out.println(list.toString());
    }

}
