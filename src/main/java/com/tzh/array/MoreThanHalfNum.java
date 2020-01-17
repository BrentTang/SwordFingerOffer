package com.tzh.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brent
 * @title: MoreThanHalfNum
 * @projectName Offer
 * @date 2019/9/23 14:44
 * @description: 数组中出现次数超过一半的数字
 *
 *  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *  例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *  由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 *  时间限制：1秒 空间限制：32768K
 */
public class MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length < 1) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > (array.length >> 1))
                return e.getKey();
        }
        return 0;
    }

}
