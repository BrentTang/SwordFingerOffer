package com.tzh.sort;

import com.tzh.sort.base.ArrayUtils;
import org.junit.Test;

/**
 * @author Brent
 * @title: HeapSort
 * @projectName Offer
 * @date 2019/9/24 17:27
 * @description: TODO
 */
public class HeapSort {

    int arrayLength = 300;

    @Test
    public void testHeapSort() {
        boolean isValid = ArrayUtils.checkSort(array ->
                HeapSort.heapSort(array) );
        System.out.println("heapSort是否有效：" + isValid);

        double time = ArrayUtils.sortEffect(array ->
                HeapSort.heapSort(array) );
        System.out.println("test heapSort：arrayLength=" + arrayLength + "，平均耗时：" + time + "ms");
    }

    public static void heapSort(int[] array) {

        // 最后一个非叶子节点
        int node = (array.length >> 1) - 1;

        // 从最后一个非叶子节点开始调整, 调整为一个大顶堆
        for (int i = node; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }

        // 堆顶元素就是当前数组最大值
        // 堆顶元素与当前数组长度最后一个交换, 最大元素就到数组最后了
        // 再调整堆, (本次调整只需要从堆顶元素进行调整, 因为刚才只是将堆顶元素与最后一个元素进行了交换, 堆顶以下的都是调整好的)
        // 每次堆顶元素的交换都是将最大值取出一次往数组末端排列
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            adjustHeap(array, 0, i);
        }

    }

    /**
     *
     * @param array 待调整的堆
     * @param node  待调整的非叶子节点
     * @param len   需要调整的区域长度 (0 - len)
     */
    public static void adjustHeap(int[] array, int node, int len) {

        int temp = array[node];
        // node * 2 + 1 -> 为当前node节点的左子节点
        for (int cur = node * 2 + 1; cur < len; cur = cur * 2 + 1) {
            // 判断当前节点的左子节点与右子节点的值
            // cur始终指向最大的一个值
            // 然后再将这个较大的值与父节点比较
            if (cur + 1 < len && array[cur] < array[cur + 1]) {
                cur++;
            }
            // 将最大的值调整到父节点
            if (array[node] < array[cur]) {
                array[node] = array[cur];
                node = cur;
            } else
                break;

            array[node] = temp;
        }
    }
}
