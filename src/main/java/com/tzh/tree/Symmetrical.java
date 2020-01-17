package com.tzh.tree;

import java.util.LinkedList;

/**
 * @author Brent
 * @title: Symmetrical
 * @projectName Offer
 * @date 2019/10/3 18:42
 * @description: 	对称的二叉树
 *
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * {8,6,6,5,7,7,5}
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class Symmetrical {

    boolean isSymmetrical(TreeNode pRoot) {
        return judge(pRoot, pRoot);
    }

    public boolean judge(TreeNode pRoot, TreeNode root) {
        if (pRoot == null && root == null)
            return true;
        if (pRoot == null || root == null)
            return false;

        if (pRoot.val != root.val)
            return false;
        return judge(pRoot.left, root.right) && judge(pRoot.right, root.left);
    }

    /*public void collect(TreeNode root, LinkedList<Integer> queue) {
        if (root == null)
            return;
        queue.addLast(root.val);
        collect(root.left, queue);
        collect(root.right, queue);
    }

    public boolean match(TreeNode root, LinkedList<Integer> queue) {
        if (root == null)
            return queue.isEmpty();
        if (queue.isEmpty())
            return false;
        if (queue.removeFirst() != root.val)
            return false;
        boolean match = match(root.left, queue);
        if (!match) return false;
        return match(root.right, queue);
    }*/

}
