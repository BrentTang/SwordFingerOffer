package com.tzh.queueAndstack;

import java.util.Stack;

/**
 * @author Brent
 * @title: StackWithMin
 * @projectName Offer
 * @date 2019/9/22 14:59
 * @description: 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class StackWithMin {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> help = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (help.size() == 0 || node < help.peek()) {
            help.push(node);
        } else {
            help.push(help.peek());
        }
    }

    public void pop() {
        data.pop();
        help.pop();
    }

    public int top() {
        if (data.size() > 0) {
            return data.peek();
        }
        return 0;
    }

    public int min() {
        if (help.size() > 0) {
            return help.peek();
        }
        return 0;
    }
}
