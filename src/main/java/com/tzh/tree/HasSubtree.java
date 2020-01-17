package com.tzh.tree;

/**
 * @author Brent
 * @title: HasSubtree
 * @projectName Offer
 * @date 2019/9/22 9:40
 * @description: 树的子结构
 *
 *  输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class HasSubtree {

    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null) return false;
        if (root1 == null && root2 != null) return false;

        boolean flag = false;
        if (root1.val == root2.val) {
            flag = isSubTree(root1, root2);
        }
        if (flag) return true;

        flag = hasSubtree(root1.left, root2);
        if (flag) return true;
        return hasSubtree(root1.right, root2);
    }


    public boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        else if (root1 == null && root2 != null)
            return false;

        if (root1.val != root2.val)
            return false;

        if (!isSubTree(root1.left, root2.left))
            return false;

        if (!isSubTree(root1.right, root2.right))
            return false;

        return true;
    }

}
