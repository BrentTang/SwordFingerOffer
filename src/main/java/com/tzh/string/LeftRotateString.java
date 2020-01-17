package com.tzh.string;

/**
 * @author Brent
 * @title: LeftRotateString
 * @projectName Offer
 * @date 2019/9/26 8:45
 * @description: 左旋转字符串
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 *  时间限制：1秒 空间限制：32768K
 */
public class LeftRotateString {

    public String leftRotateString(String str,int n) {
        if (n < 1 || n > str.length() || str.length() < 1) return str;
        return str.substring(n) + str.substring(0, n);
    }

}
