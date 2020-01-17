package com.tzh.other;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Brent
 * @title: isContinuous
 * @projectName Offer
 * @date 2019/9/26 9:06
 * @description: 	扑克牌顺子
 *
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class Continuous {

    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 1) return false;

        Arrays.sort(numbers);
        int king = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                king++;
            else break;
        }
        if (king == numbers.length - 1) return true;
        int kingIndex = king;
        for (int i = numbers.length - 1; i > kingIndex; i--) {
            if (i - 1 >= kingIndex) {
                if (numbers[i] == numbers[i - 1]) return false;
                else if (numbers[i] - numbers[i - 1] > 1) {
                    if (king < 1 || king < numbers[i] - numbers[i - 1] - 1)
                        return false;
                    king -= numbers[i] - numbers[i - 1] - 1;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] num = {1,0,3,5,0};
        System.out.println(isContinuous(num));
    }

}
