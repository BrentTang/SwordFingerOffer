package com.tzh.string;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Brent
 * @title: FirstAppearingOnce
 * @projectName Offer
 * @date 2019/10/3 9:25
 * @description: 字符流中第一个不重复的字符
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class FirstAppearingOnce {

    LinkedList<Character> data = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (data.contains(ch)) {
            data.removeFirstOccurrence(ch);
        } else {
            data.addLast(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        if (!data.isEmpty())
            return data.peekFirst();
        return '#';
    }

    @Test
    public void test() {
        FirstAppearingOnce o = new FirstAppearingOnce();
        String str = "google";
        for (char c : str.toCharArray()) {
            o.Insert(c);
        }
        System.out.println(o.firstAppearingOnce());
    }

}
