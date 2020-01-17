package com.tzh.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Brent
 * @title: TreeSerialize
 * @projectName Offer
 * @date 2019/10/5 9:47
 * @description: 	序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class TreeSerialize {

    int index = -1;
    String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#!");
            return sb.toString();
        }

        sb.append(root.val+"!");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    TreeNode deserialize(String str) {
        TreeNode node = null;
        index++;
        String[] strr = str.split("!");
        if(!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }
        return node;
    }

    /*String Serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder res = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node != null) {
                res.append(node.val + "!");
            } else {
                res.append("#!");
                continue;
            }

            if (node.left != null || node.right != null) {
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        return res.toString();
    }

    TreeNode Deserialize(String str) {
        if (str.equals("#")) return null;
        ArrayList<TreeNode> nodes = new ArrayList<>();
        for (String s : str.split("!")) {
            if (s.equals("#"))
                nodes.add(null);
            else
                nodes.add(new TreeNode(Integer.valueOf(s)));
        }
        for (int i = 0; i < (nodes.size() >> 1); i++) {
            if (nodes.get(i) == null)
                continue;
            TreeNode node = nodes.get(i);
            int left = (i << 1) + 1;
            if (left < nodes.size()) {
                node.left = nodes.get(left);
            }
            if (left + 1 < nodes.size()) {
                node.right = nodes.get(left + 1);
            }
        }
        return nodes.get(0);
    }*/

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        String str = serialize(root);
        System.out.println(str);

        TreeNode r = deserialize(str);

        /*ArrayList<ArrayList<Integer>> nodes = Print(r);
        System.out.println(nodes.toString());*/
    }

    /*ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        TreeNode end = pRoot;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(pRoot);
        ArrayList<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            temp.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
            if (node == end) {
                res.add(temp);
                temp = new ArrayList<>();
                end = queue.peekLast();
            }
        }
        return res;
    }*/

}
