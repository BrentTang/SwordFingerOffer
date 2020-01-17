package com.tzh.tree;

/**
 * @author Brent
 * @title: KthNodeOfBST
 * @projectName Offer
 * @date 2019/10/6 9:39
 * @description: 二叉搜索树的第k个结点
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）  中，按结点数值大小顺序第三小结点的值为4。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class KthNodeOfBST {

    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) return null;

        TreeNode node = KthNode(pRoot.left, k);
        if (node != null) return node;
        if (++index == k) return pRoot;
        return KthNode(pRoot.right, k);
    }
}
