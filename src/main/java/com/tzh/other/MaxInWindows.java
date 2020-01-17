package com.tzh.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Brent
 * @title: MaxInWindows
 * @projectName Offer
 * @date 2019/10/7 7:32
 * @description: 	滑动窗口的最大值
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class MaxInWindows {

    /**
     * 数组的第一个数字是2，把它存入队列中。第二个数字是3，比2大，所以2不可能是滑动窗口中的最大值，
     * 因此把2从队列里删除，再把3存入队列中。第三个数字是4，比3大，同样的删3存4。
     * 此时滑动窗口中已经有3个数字，而它的最大值4位于队列的头部。
     *
     * 第四个数字2比4小，但是当4滑出之后它还是有可能成为最大值的，所以我们把2存入队列的尾部。
     * 下一个数字是6，比4和2都大，删4和2，存6。就这样依次进行，最大值永远位于队列的头部。
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size < 1 || size > num.length) return res;
        LinkedList<Integer> queue = new LinkedList<>();
        int max = num[0];
        queue.addLast(num[0]);
        for (int i = 1; i < size; i++) {
            if (num[i] > max) {
                max = num[i];
                queue.clear();
            }
            queue.addLast(num[i]);
        }
        res.add(max);
        for (int i = size; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
                queue.clear();
                queue.addLast(num[i]);
                res.add(max);
            } else {
                if (queue.size() >= size) {
                    queue.removeFirst();
                    max = num[i - size + 1];
                    int index = i - size + 1;
                    for (int j = i - size + 2; j <= i; j++) {
                        if (max < num[j]) {
                            max = num[j];
                            index = j;
                        }
                    }
                    queue.clear();
                    for (int j = index; j <= i; j++)
                        queue.addLast(num[j]);
                    res.add(max);
                } else {
                    res.add(max);
                    queue.addLast(num[i]);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int [] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        System.out.println(maxInWindows(num, size).toString());
    }

}
