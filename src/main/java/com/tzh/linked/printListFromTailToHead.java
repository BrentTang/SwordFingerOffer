package com.tzh.linked;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Brent
 * @title: PrintLinkedListFromEndToHead
 * @projectName Offer
 * @date 2019/9/21 9:13
 * @description: 从尾到头打印链表
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class printListFromTailToHead {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) return list;

        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        Instant start = Instant.now();
        ArrayList<Integer> list = printListFromTailToHead(listNode);
        Instant end = Instant.now();
        System.out.println("result: " + list.toString());
        System.out.println("time: " + Duration.between(start, end).toMillis());
    }

}
