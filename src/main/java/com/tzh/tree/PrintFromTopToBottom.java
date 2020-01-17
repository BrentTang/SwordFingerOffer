package com.tzh.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Brent
 * @title: PrintFromTopToBottom
 * @projectName Offer
 * @date 2019/9/22 15:58
 * @description: 从上往下打印二叉树
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            res.add(node.val);
            if (node.left != null)
                queue.addLast(node.left);
            if (node.right != null)
                queue.addLast(node.right);
        }
        return res;
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(printFromTopToBottom(root).toString());
    }

}
