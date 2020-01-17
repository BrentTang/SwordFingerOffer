package com.tzh.tree;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

/**
 * @author Brent
 * @title: ReConstructBinaryTree
 * @projectName Offer
 * @date 2019/9/21 9:28
 * @description: 	从尾到头打印链表
 *
 *  输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *  假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *  例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 *  则重建二叉树并返回。
 *
 *  时间限制：1秒 空间限制：32768K
 */
public class ReConstructBinaryTree {

    //Definition for binary tree
    /*public class TreeNode<Integer> {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }*/

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length < 1 || in.length < 1 || pre.length != in.length) return null;

        TreeNode root = helper(pre, in, 0, 0, in.length);
        return root;
    }

    public TreeNode helper(int[] pre, int[] in, int preRootIndex, int start, int end) {
        // 根存在  并且   start至end范围内存在节点
        if (preRootIndex >= pre.length || end <= start)
            return null;

        int inRootIndex = search(in, pre[preRootIndex]);
        TreeNode root = new TreeNode(pre[preRootIndex]);
        // inRootIndex - start = 左节点数量(以当前inRootIndex为根的左节点数量)
        if (inRootIndex - start > 0) {
            // 如果存在左节点, 左节点的位置在前序遍历的preRootIndex + 1位置
            // preRootIndex + 1 => 在前序遍历中 该根节点的左节点位置为 当前根节点位置 + 1
            root.left = helper(pre, in, preRootIndex + 1, start, inRootIndex);
        }
        // end - inRootIndex + 1 = 右节点数量(以当前inRootIndex为根的右节点数量)
        if (end - inRootIndex + 1 > 0) {
            // 如果存在右节点, 右节点的位置在前序遍历的preRootIndex + inRootIndex - start + 1位置
            // preRootIndex + inRootIndex - start + 1 => 在前序遍历中 该根节点的右节点位置为 当前根节点位置 + 左节点个数 + 1
            root.right = helper(pre, in, preRootIndex + inRootIndex - start + 1, inRootIndex + 1, end);
        }

        return root;
    }



    /*public TreeNode construct(int [] pre, int [] in, int preRootIndex, Set<Integer> nodes, int start, int end) {
        if (!nodes.add(pre[preRootIndex]))
            return null;
        int inRootIndex = search(in, pre[preRootIndex]);
        TreeNode root = new TreeNode(pre[preRootIndex]);
        if (inRootIndex - start > 0 && preRootIndex + 1 < pre.length && nodes.size() < pre.length) {
            root.left = construct(pre, in, preRootIndex + 1, nodes, 0, inRootIndex);
        }

        if (end - inRootIndex - 1 > 0 && preRootIndex + inRootIndex - start + 1 < pre.length && nodes.size() < pre.length) {
            root.right = construct(pre, in, preRootIndex + inRootIndex - start + 1, nodes, inRootIndex + 1, end);
        }

        return root;
    }*/

    public int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        Instant start = Instant.now();
        TreeNode root = reConstructBinaryTree(pre, in);
        Instant end = Instant.now();
        System.out.println("result: ");
        //visitTreeByLayer(root);
        System.out.println("time: " + Duration.between(start, end).toMillis());
    }

    /*public void visitTreeByLayer(TreeNode<Integer> root) {
        if (root == null) {
            return ;
        }
        LinkedList<TreeNode<Integer>> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.removeFirst();
            System.out.print(node.val + ", ");
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
    }*/

}
