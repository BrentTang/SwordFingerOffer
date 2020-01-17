package com.tzh.string;

import java.util.ArrayList;

/**
 * @author Brent
 * @title: FirstNotRepeatingChar
 * @projectName Offer
 * @date 2019/9/24 10:28
 * @description: 第一个只出现一次的字符位置
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) return -1;

        int[] chs = new int['z' + 1];
        for (char c : str.toCharArray())
            chs[(int) c] += 1;

        for (int i = 0; i < str.length(); i++)
            if (chs[(int) str.charAt(i)] == 1)
                return i;

        return -1;
    }

}
