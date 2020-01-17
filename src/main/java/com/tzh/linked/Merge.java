package com.tzh.linked;

/**
 * @author Brent
 * @title: Merge
 * @projectName Offer
 * @date 2019/9/22 9:32
 * @description: 合并两个排序的链表
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class Merge {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge(ListNode list1,ListNode list2) {
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }

        if (list1 != null) cur.next = list1;
        if (list2 != null) cur.next = list2;

        return head.next;
    }

}
