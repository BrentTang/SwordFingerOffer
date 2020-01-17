package com.tzh.string;

import org.junit.Test;

/**
 * @author Brent
 * @title: Match
 * @projectName Offer
 * @date 2019/9/27 18:29
 * @description: 正则表达式匹配
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class Match {

    public boolean match(char[] str, char[] pattern) {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];

        dp[0][0] = true;

        for (int i = 1; i <= pattern.length; i++) {
            if (pattern[i - 1] == '*' && dp[0][i - 2])
                dp[0][i] = true;
        }

        for (int i = 1; i <= str.length; i++) {
            for (int j = 1; j <= pattern.length; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*') {
                    if (str[i - 1] != pattern[j - 2] && pattern[j - 2] != '.')
                        dp[i][j] = dp[i][j - 2];
                    else
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[str.length][pattern.length];
    }

    @Test
    public void test() {
        char[] str = {'a', 'a', 'b'};
        char[] pattern = {'a', '*', 'b'};
        System.out.println(match(str, pattern));
    }

    /*public boolean match(char[] str, char[] pattern) {
        int sp = 0;
        int pp = 0;
        int star = -1;
        // 记录从遇到 * 开始，这个 * 匹配一个字符 match++
        int match = 0;
        while (sp < str.length) {
            if (pp < pattern.length && (str[sp] == pattern[pp] || pattern[pp] == '.')) {
              sp++;
              pp++;
            } else if (pp < pattern.length && pattern[pp] == '*') {
                // 记录 * 位置
                star = pp;
                // 记录 匹配到的位置
                match = sp;
                // 这里 pp++ 主要是为了判断这个 * 是否需要代替字符
                pp++;
            } else if (star != -1) {
                // 表示 不匹配了 但是star!=-1 说明之前遇到过 * 所以这里使用 * 来匹配任意字符
                // 依然从上一个 * 的下一位开始匹配
                pp = star + 1;
                // * 匹配到一位
                match++;
                // sp也移动到即将要匹配的字符索引
                sp = match;
            } else
                return false;

        }
        // 如果 pattern 还未匹配完 检查pattern后面是否都是 *
        while (pp < pattern.length && pattern[pp] == '*') pp++;
        // 知道 pattern 匹配完成才算 匹配成功
        return pp == pattern.length;
    }*/

}
