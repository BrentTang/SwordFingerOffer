package com.tzh.string;

import org.junit.Test;

/**
 * @author Brent
 * @title: ReverseSentence
 * @projectName Offer
 * @date 2019/9/26 8:56
 * @description: 	翻转单词顺序列
 *
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class ReverseSentence {

    public String reverseSentence(String str) {
        if (str == null || str.length() < 2) return str;

        StringBuilder res = new StringBuilder();
        String[] words = str.split(" ");
        if (words.length < 1)
            return str;
        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]);
            if (i > 0)
                res.append(" ");
        }
        return res.toString();
    }

    @Test
    public void test() {
        String str = "  ";
        System.out.println("-" + reverseSentence(str) + "-");
    }

}
