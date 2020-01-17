package com.tzh.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Brent
 * @title: Solution
 * @projectName Offer
 * @date 2019/10/13 21:33
 * @description: TODO
 */
public class Solution {

    public int solution(int len) {
        if (len < 3) return len;
        int f1 = 1;
        int f2 = 2;
        int f = 3;
        for (int i = 3; i <= len; i++) {
            f = f1 + f2;
            int temp = f2;
            f2 = f1 + f2;
            f1 = temp;
        }
        return f;
    }

    @Test
    public void test() {
//        System.out.println(solution(4));
        System.out.println(helper(10));
    }

    public int helper(int n){

    LinkedList<Integer> circle = new LinkedList<>();
    //ArrayList<Integer> circle = new ArrayList<>();

    for(int i = 0; i < n; i++){

        circle.addLast(i + 1);

    }

    int count = 1;

    while(circle.size() > 1){

        Iterator<Integer> it = circle.iterator();

        while(it.hasNext() && circle.size() > 1){
            it.next();

            if(count == 3){

                it.remove();

                count = 1;

            } else {
                count++;
            }

        }

    }
    return circle.peekFirst();

    }

}
