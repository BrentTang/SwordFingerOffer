package com.tzh.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Brent
 * @title: PrintAsRow
 * @projectName Offer
 * @date 2019/10/4 11:24
 * @description: 把二叉树打印成多行
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class PrintAsRow {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        TreeNode end = pRoot;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(pRoot);
        ArrayList<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            temp.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
            if (node == end) {
                res.add(temp);
                temp = new ArrayList<>();
                end = queue.peekLast();
            }
        }
        return res;
    }

}
