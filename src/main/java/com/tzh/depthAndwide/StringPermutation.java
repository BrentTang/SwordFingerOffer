package com.tzh.depthAndwide;

import java.util.*;

/**
 * @author Brent
 * @title: StringPermutation
 * @projectName Offer
 * @date 2019/9/23 9:26
 * @description: 字符串的排列
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 *  输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class StringPermutation {

    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() < 1) return res;
        HashSet<String> single = new HashSet<>();
        helper(new StringBuffer(str), res, new StringBuffer(), single);

        return res;
    }

    public void helper(StringBuffer str, ArrayList<String> res, StringBuffer temp, HashSet<String> single) {
        if (str.length() == 0) {
            if (!single.contains(temp.toString())) {
                res.add(temp.toString());
                single.add(temp.toString());
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (temp.length() == 0) {
                int index = str.indexOf(str.charAt(i) + "");
                if (index < i)
                    continue;
            }
            temp.append(str.charAt(i));
            str.deleteCharAt(i);
            helper(str, res, temp, single);
            str.insert(i, temp.charAt(temp.length() - 1));
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}
