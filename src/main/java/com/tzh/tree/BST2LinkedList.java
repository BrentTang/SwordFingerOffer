package com.tzh.tree;

import java.util.ArrayList;

/**
 * @author Brent
 * @title: BST2LinkedList
 * @projectName Offer
 * @date 2019/9/23 8:57
 * @description: 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class BST2LinkedList {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;

        ArrayList<TreeNode> sortNodes = new ArrayList<>();
        helper(pRootOfTree, sortNodes);
        for (int i = 0; i < sortNodes.size(); i++) {
            TreeNode node = sortNodes.get(i);

            if (i - 1 >= 0)
                node.left = sortNodes.get(i - 1);
            if (i + 1 < sortNodes.size())
                node.right = sortNodes.get(i + 1);
        }
        return sortNodes.get(0);
    }

    public void helper(TreeNode root, ArrayList<TreeNode> sortNodes) {
        if (root == null)
            return;

        helper(root.left, sortNodes);
        sortNodes.add(root);
        helper(root.right, sortNodes);
    }

}
