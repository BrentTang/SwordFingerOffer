package com.tzh.tree;

/**
 * @author Brent
 * @title: GetNextNode
 * @projectName Offer
 * @date 2019/10/3 17:43
 * @description: 	二叉树的下一个结点
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class GetNextNode {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;

        // 如果右子树不为空，则下一个节点一定在右子树
        // 一直从右子树往下找，直到右子树的第一个子叶子节点
        if (pNode.right != null)
            return helper(pNode.right);

        TreeLinkNode parent = pNode.next;
        // 往上找
        if (parent != null) {
            // 左节点
            if (parent.left == pNode)
                return parent;
            // 右节点
            // 一直往上找，直到父节点的左节点为当前节点时，下一个节点就是父节点
            TreeLinkNode su = parent;
            while (su.next != null && su.next.left != su) su = su.next;
            return su.next;
        }

        // 父节点
        return parent;
    }

    public TreeLinkNode helper(TreeLinkNode node) {
        if (node == null)
            return null;
        TreeLinkNode target = helper(node.left);
        if (target != null) return target;
        return node;
    }



}
