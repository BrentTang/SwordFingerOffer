package com.tzh.queueAndstack;

import java.util.Stack;

/**
 * @author Brent
 * @title: QueueByStack
 * @projectName Offer
 * @date 2019/9/21 15:10
 * @description: 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class QueueByStack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int node = stack1.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return node;
    }

}
