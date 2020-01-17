package com.tzh.other;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author Brent
 * @title: GetMedianByStream
 * @projectName Offer
 * @date 2019/10/6 10:13
 * @description: 	数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class GetMedianByStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (minHeap.size() <= maxHeap.size()) {
            // 放入小堆
            if (minHeap.isEmpty()) {
                minHeap.add(num);
                return;
            }
            if (num < minHeap.peek()) {
                minHeap.add(num);
            } else {
                if (num < maxHeap.peek()) {
                    minHeap.add(num);
                } else {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(num);
                }
            }
        } else {
            if (maxHeap.isEmpty()) {
                if (num < minHeap.peek()) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(num);
                } else
                    maxHeap.add(num);
                return;
            }

            if (num > maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                if (num < minHeap.peek()) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
            }
        }
    }

    /**
     * 如果容器中数据的数目是奇数，那么两个指针指向同一个数据。
     * 我们可以发现，整个数据容器被分成两个部分。位于容器左边部分的数据结构比右边的数据结构小。
     * 另外，p1指针指向的数据是左边部分最大的数，p2指向的是右边部分最小的数。
     *
     * 首先要保证数据平均分配到两个堆中，因此两个堆中的数据的数目之差不能为1。
     * 为了实现平均分配，可以在数据的总数目是偶数的情况下把新数据插入最小堆，否则插入最大堆。
     *
     * 还要保证最大堆的所有数都大于最小堆，因此按照前面的分配规则，会把新的数据插入最小堆。
     * 如果此时插入最小堆的数据大于最大堆的最小值，那么它就不能成为最小堆的数据，
     * 因此我们需要把这个新数据先插入最大堆，然后取出最大堆里最小值，把最小值插入最小堆中，
     * 以此来满足我们的规则——最小堆中所有数字都大于最大堆的数字。同理可插入新数据进入最大堆。
     *
     * @return
     */
    public Double GetMedian() {
        if (minHeap.size() == maxHeap.size())
            return Double.valueOf(minHeap.peek() + maxHeap.peek()) / 2.0;
        return Double.valueOf(minHeap.peek());
    }

    @Test
    public void test() {
        GetMedianByStream g = new GetMedianByStream();
        /*g.Insert(2);
        g.Insert(3);
        g.Insert(1);
        g.Insert(4);*/
        Integer[] n = {5,2,3,4,1,2,6,7,0,8};
        for (Integer i : n) {
            g.Insert(i);
        }
        System.out.println(g.GetMedian());
    }

}
