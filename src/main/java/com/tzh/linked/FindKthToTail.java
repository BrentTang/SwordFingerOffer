package com.tzh.linked;

import org.junit.Test;

/**
 * @author Brent
 * @title: FindKthToTail
 * @projectName Offer
 * @date 2019/9/21 19:43
 * @description: 链表中倒数第k个结点
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * ***考虑 k 是否越界——小了 或 大了
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class FindKthToTail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findKthToTail(ListNode head,int k) {
        if (head == null || k < 1) return null;

        ListNode target = head;
        ListNode before = head;
        int i = 0;
        for (; before.next != null; i++) {
            if (i >= k - 1) {
                target = target.next;
            }
            before = before.next;
        }

        if (k - i > 1)
            return null;

        return new ListNode(target.val);
    }

    @Test
    public void test() {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);

        ListNode t = findKthToTail(h, 1);
        System.out.println(t.val);
    }

}
