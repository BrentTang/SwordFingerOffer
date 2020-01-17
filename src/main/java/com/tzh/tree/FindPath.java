package com.tzh.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Brent
 * @title: FindPath
 * @projectName Offer
 * @date 2019/9/22 16:49
 * @description: 二叉树中和为某一值的路径
 *
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一**直到叶结点**所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class FindPath {

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        helper(root, target, res, new ArrayList<>());

        Collections.sort(res, (o1, o2) -> o2.size() - o1.size());
        return res;
    }

    public void helper(TreeNode root, int target, ArrayList<ArrayList<Integer>> res,
                       ArrayList<Integer> list) {
        if (root == null)
            return;

        target -= root.val;
        if (target < 0)
            return ;

        list.add(root.val);

        helper(root.left, target, res, list);
        helper(root.right, target, res, list);
        // 必须满足该节点为叶子节点
        if (target == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<>(list));

        list.remove(list.size() - 1);
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        ArrayList<ArrayList<Integer>> paths = findPath(root, 6);
        for (ArrayList<Integer> p : paths) {
            System.out.println(p.toString());
        }
    }

}
