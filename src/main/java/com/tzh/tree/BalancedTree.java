package com.tzh.tree;

import java.util.LinkedList;

/**
 * @author Brent
 * @title: BalancedTree
 * @projectName Offer
 * @date 2019/9/25 9:30
 * @description: 平衡二叉树
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class BalancedTree {

    public boolean isBalanced_Solution(TreeNode root) {
        if (root == null) return true;

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return right > left ? right - left <= 1 : left - right <=1;
    }

    public int treeDepth(TreeNode root) {
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
