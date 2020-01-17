package com.tzh.tree;

import java.util.LinkedList;

/**
 * @author Brent
 * @title: TreeDepth
 * @projectName Offer
 * @date 2019/9/25 9:10
 * @description: 二叉树的深度
 *
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;

        TreeNode lineLast = root;
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node.left != null)
                queue.addLast(node.left);
            if (node.right != null)
                queue.addLast(node.right);

            if (node == lineLast) {
                lineLast = queue.peekLast();
                depth++;
            }
        }

        return depth - 1;
    }

}
