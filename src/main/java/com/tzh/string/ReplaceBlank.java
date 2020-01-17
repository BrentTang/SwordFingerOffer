package com.tzh.string;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

/**
 * @author Brent
 * @title: ReplaceBlank
 * @projectName Offer
 * @date 2019/9/21 9:00
 * @description: 替换空格
 *
 *  请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *  例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class ReplaceBlank {

    public String replaceSpace(StringBuffer str) {
        int blank = str.indexOf(" ");
        while (blank != -1) {
            str.replace(blank, blank + 1, "%20");
            blank = str.indexOf(" ");
        }
        return str.toString();
    }

    @Test
    public void test() {
        StringBuffer str = new StringBuffer("We Are Happy");
        Instant start = Instant.now();
        String s = replaceSpace(str);
        Instant end = Instant.now();
        System.out.println("result: " + s);
        System.out.println("time: " + Duration.between(start, end).toMillis());
    }

}
