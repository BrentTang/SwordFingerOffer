package com.tzh.tree;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;
import org.junit.Test;

import javax.crypto.AEADBadTagException;

/**
 * @author Brent
 * @title: VerifySquenceOfBST
 * @projectName Offer
 * @date 2019/9/22 16:13
 * @description: 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 *  时间限制：1秒 空间限制：32768K
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length < 1) return false;

        return helper(sequence, 0, sequence.length);
    }

    public boolean helper(int[] sequence, int start, int end) {
        if (start >= end - 1)
            return true;

        int root = sequence[end - 1];
        int lcount = 0;
        for (int i = start; i < end - 1; i++, lcount++) {
            if (sequence[i] > root)
                break;
        }

        for (int i = start + lcount; i < end - 1; i++) {
            if (sequence[i] < root)
                return false;
        }

        boolean flag = helper(sequence, start, start + lcount);
        return flag && helper(sequence, start + lcount, end - 1);
    }

    @Test
    public void test() {
        //int[] sequence = {5,7,6,9,11,10,8};
        int[] sequence = {1,3};
        System.out.println(verifySquenceOfBST(sequence));
    }

}
