package com.tzh.linked;

import java.awt.*;

/**
 * @author Brent
 * @title: ReverseList
 * @projectName Offer
 * @date 2019/9/22 9:25
 * @description: 反转链表
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) return head;

        ListNode newHead = new ListNode(-1);
        ListNode temp = null;
        ListNode cur = head;

        while (cur != null) {
            temp = cur;
            cur = cur.next;
            temp.next = newHead.next;
            newHead.next = temp;
        }
        return newHead.next;
    }

}
