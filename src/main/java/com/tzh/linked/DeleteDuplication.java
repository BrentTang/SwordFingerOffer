package com.tzh.linked;

import org.junit.Test;

/**
 * @author Brent
 * @title: DeleteDuplication
 * @projectName Offer
 * @date 2019/10/3 15:35
 * @description: 	删除链表中重复的结点
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode cur = pHead, start = head;

        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) cur = cur.next;
            if (start.next != cur) {
                start.next = cur.next;
            } else {
                start = cur;
            }
            cur = cur.next;
        }

        return head.next;
    }

    @Test
    public void test() {
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(3);
        l.next.next.next.next.next = new ListNode(4);
        l.next.next.next.next.next.next = new ListNode(4);
        l.next.next.next.next.next.next.next = new ListNode(5);

        ListNode h = deleteDuplication(l);

        while (h != null) {
            System.out.print(h.val + "->");
            h = h.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
