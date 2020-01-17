package com.tzh.other;

/**
 * @author Brent
 * @title: GetUglyNumber
 * @projectName Offer
 * @date 2019/9/24 10:04
 * @description: 丑数
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class GetUglyNumber {

    /**
     * 注意每个丑数毕为前面的丑数乘以2、3或5得到的；
     * 把现有最大丑数记为M，则把第一个乘以2后大于M的结果记为M2，
     * 同理，把每个丑数乘以3和5 ，得到的第一个大于M的结果为M3和M5，
     * 那么下一个丑数必为M2/M3/M5这三个数的最小者。
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;

        int[] nums = new int[index];
        nums[0] = 1;
        int n2 = 0, n3 = 0, n5 = 0;
        for (int i = 1; i < index; i++) {
            nums[i] = Math.min(nums[n2] * 2, nums[n3] * 3);
            nums[i] = Math.min(nums[i], nums[n5] * 5);

            if (nums[i] == nums[n2] * 2) n2++;
            if (nums[i] == nums[n3] * 3) n3++;
            if (nums[i] == nums[n5] * 5) n5++;
        }
        return nums[index - 1];
    }

}
