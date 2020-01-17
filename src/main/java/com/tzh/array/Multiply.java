package com.tzh.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Brent
 * @title: Multiply
 * @projectName Offer
 * @date 2019/9/27 18:03
 * @description: 构建乘积数组
 *
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class Multiply {

    /**
     * B[i]的左半部分(红色部分)和B[i-1]有关（将B[i]的左半部分乘积看成C[i]，有C[i]=C[i-1]*A[i-1]），
     * B[i]的右半部分(紫色部分)与B[i+1]有关（将B[i]的右半部分乘积看成D[i]，有D[i]=D[i+1]*A[i+1]），
     *
     * 因此我们先从0到n-1遍历，计算每个B[i]的左半部分；
     * 然后定义一个变量temp代表右半部分的乘积，从n-1到0遍历，令B[i]*=temp，
     * 而每次的temp与上次的temp关系即为temp*=A[i+1]。
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length < 1) return null;

        int[] b = new int[A.length];
        b[0] = 1;
        // c[i] = c[i - 1] * A[i - 1]
        for (int i = 1; i < A.length; i++) {
            if (i - 1 >= 0)
                b[i] = b[i - 1] * A[i - 1];
        }

        // d[i] = d[i + 1] * A[i + 1]
        int temp = 1;
        for (int i = A.length - 2; i >= 0 ; i--) {
            temp *= A[i + 1];
            // 最后 b[i] = c[i] * d[i];
            b[i] *= temp;
        }

        return b;
    }

    @Test
    public void test() {
        int[] A = {1,2,3,4,5};

        System.out.println(Arrays.toString(multiply(A)));
    }

}
