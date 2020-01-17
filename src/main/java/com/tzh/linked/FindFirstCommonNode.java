package com.tzh.linked;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author Brent
 * @title: FindFirstCommonNode
 * @projectName Offer
 * @date 2019/9/25 8:30
 * @description: 两个链表的第一个公共结点
 *
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class FindFirstCommonNode {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        if (pHead1 == pHead2) return pHead1;

        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode cur = pHead1;
        while (cur != null) {
            listNodes.add(cur);
            cur = cur.next;
        }

        cur = pHead2;
        while (cur != null) {
            if (listNodes.contains(cur))
                return cur;
            cur = cur.next;
        }

        return null;
    }

    @Test
    public void test() {
        //构造链表结构测试用
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        //第一个List
        // a -> b -> c -> f -> g
        a.next = b;
        b.next = c;
        c.next = f;
        f.next = g;
        //第二个List
        // d -> e -> f -> g
        d.next = e;
        e.next = f;
        f.next = g;

        ListNode node = findFirstCommonNode(a, d);
        System.out.println(node.val);
    }

}
