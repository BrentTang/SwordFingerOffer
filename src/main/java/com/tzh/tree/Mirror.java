package com.tzh.tree;

/**
 * @author Brent
 * @title: Mirror
 * @projectName Offer
 * @date 2019/9/22 10:05
 * @description: 二叉树的镜像
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class Mirror {

    public void mirror(TreeNode root) {
        if (root == null)
            return ;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);

        return;
    }

}
