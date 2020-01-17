package com.tzh.array;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Brent
 * @title: GetLeastNumbers
 * @projectName Offer
 * @date 2019/9/23 15:05
 * @description: 最小的K个数
 *
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class GetLeastNumbers {

    /**
     * 实现方法：大堆
     *      因为TreeSet底层是TreeMap实现，TreeMap实现了红黑树
     *      所以默认是一个大堆
     *      1. 堆中元素小于 k 时，直接添加
     *      2. 堆中元素达到 k 时，判断将要添加的元素是否大于堆顶元素
     *          I. 如果大于堆顶元素，该元素一定不是 前 k 个最小数
     *          II. 如果小于堆顶元素，则删除堆顶元素，将该元素插入堆中
     *      Notes: 由于TreeSet实现红黑树(大堆) 所以直接使用Api
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k > input.length || k < 1)
            return res;

        TreeSet<Integer> kset = new TreeSet<>();
        for (int e : input) {
            if (kset.size() < k)
                kset.add(e);
            else if (e < kset.last()) {
                // last() 方法是获取堆顶元素
                kset.remove(kset.last());
                // 加入元素时会调整堆
                kset.add(e);
            }
        }

        for (Integer integer : kset) {
            res.add(integer);
        }

        return res;
    }

}
