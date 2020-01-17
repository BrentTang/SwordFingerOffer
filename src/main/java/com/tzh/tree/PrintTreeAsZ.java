package com.tzh.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author Brent
 * @title: PrintTreeAsZ
 * @projectName Offer
 * @date 2019/10/4 9:16
 * @description: 	按之字形顺序打印二叉树
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class PrintTreeAsZ {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;

        TreeNode end = pRoot;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(pRoot);
        boolean l2r = true;
        ArrayList<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            temp.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
            if (end == node) {
                res.add(l2r ? temp
                        : (ArrayList) temp.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
                temp = new ArrayList<>();
                end = queue.peekLast();
                l2r = !l2r;
            }
        }
        return res;
    }

}
