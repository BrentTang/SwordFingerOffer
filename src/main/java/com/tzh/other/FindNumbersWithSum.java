package com.tzh.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Brent
 * @title: FindNumbersWithSum
 * @projectName Offer
 * @date 2019/9/25 17:21
 * @description: 和为S的两个数字
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class FindNumbersWithSum {

    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length < 2 || sum < array[0]) return result;
        HashMap<Integer, Integer> map = new HashMap<>();

        int mul = 0;
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(sum - array[i])) {
                Integer index = map.get(sum - array[i]);
                if (i != index && (array[i] * array[index] < mul || i1 == i2)) {
                    mul = array[i] * array[index];
                    i1 = array[i]; i2 = array[index];
                }
            } else
                map.put(array[i], i);
        }
        if (i1 != i2) {
            if (i1 < i2) {
                result.add(i1);
                result.add(i2);
            } else {
                result.add(i2);
                result.add(i1);
            }
        }

        return result;
    }

    @Test
    public void test() {
        int[] array = {2,4,3,6,3,2,5,5};
        int sum = 9;
        ArrayList<Integer> res = findNumbersWithSum(array, sum);
        System.out.println(res.toString());
    }

}
