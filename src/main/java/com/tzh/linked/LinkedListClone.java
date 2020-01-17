package com.tzh.linked;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brent
 * @title: LinkedListClone
 * @projectName Offer
 * @date 2019/9/22 17:25
 * @description: 复杂链表的复制
 *
 *  输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 *  另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 *  （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class LinkedListClone {

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode cur = pHead;
        RandomListNode newHead = new RandomListNode(-1);

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        // 复制节点  N -> N'
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            // 保存 N -> N'
            map.put(cur, newNode);

            newNode.next = cur.next;
            cur.next = newNode;
            // 下一个 old节点
            cur = newNode.next;
        }

        cur = pHead;
        // 调整关系
        while (cur != null) {
            if (cur.random != null) {
                RandomListNode random = map.get(cur.random);
                cur.next.random = random;
            }

            cur = cur.next.next;
        }

        cur = pHead;
        RandomListNode newCur = newHead;
        // 得到新链表
        while (cur != null) {
            newCur.next = cur.next;

            cur.next = cur.next.next;

            newCur = newCur.next;
            cur = cur.next;
        }

        return newHead.next;
    }

    @Test
    public void test() {

    }

}
