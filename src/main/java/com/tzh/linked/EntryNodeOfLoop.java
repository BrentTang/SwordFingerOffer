package com.tzh.linked;

import java.util.HashSet;

/**
 * @author Brent
 * @title: EntryNodeOfLoop
 * @projectName Offer
 * @date 2019/10/3 15:25
 * @description: 链表中环的入口结点
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class EntryNodeOfLoop {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = pHead;
        while (cur != null) {
            if (!set.add(cur))
                return cur;
            cur = cur.next;
        }

        return null;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
