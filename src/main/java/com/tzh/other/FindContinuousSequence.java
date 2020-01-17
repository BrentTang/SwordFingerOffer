package com.tzh.other;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Brent
 * @title: FindContinuousSequence
 * @projectName Offer
 * @date 2019/9/25 16:15
 * @description: 	和为S的连续正数序列
 *
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class FindContinuousSequence {

    /**
     * (a + b)(b - a + 1) = 2 * sum;此为等差数列公式。
     * 令i = b - a + 1(项数), j = a + b（首末项之和）;
     * 现讨论取值范围。i >= 2（序列中至少有2项）, j >= 3（序列之和至少为3）；
     * 隐藏的关系是： j > i同时还有 i * j = 2 * sum，进行放缩之后就有 i * i < 2 * sum，即 i < 根号（2 * sum）。
     * 对i进行遍历，找出i,j∈正整数且j - i + 1 (= 2a)为偶的取值。
     *
     * 1. n = 2k + 1时，n项连续正数序列的和为S的条件:
     *    n & 1 && S % n == 0 解读 逻辑与的左边要求n为奇数，右边要求整个序列的平均数恰好为中间数。
     *
     * 2. n = 2k时，n项连续正数序列的和为S的条件：
     *    S % n * 2 == n  解读  S % n 的结果是中间两项左边的那项，乘2刚好是项数。
     *    举例，现有S = 39,6个连续正数序列和式能不能为S呢？
     *    套用公式，39 % 6 * 2 =6 == 6，我们也知道，这次的序列是 4、5、6、7、8、9，
     *    取余的结果为3对应着值为6的那一项，也就是中间项左边的那一项。
     *
     * 3. 和为S，项数为n，如何写出这个序列？ 
     *    S / n - (n-1) / 2  解读  执行的除法是地板除法（floor），不管最终结果有无小数都直接舍去。
     *    仍使用上述例子，39 / 6 = 6，6恰好是中间项左边的那一项，6 - （6-1）/ 2 = 4，
     *    恰好是序列最左端。序列写出来就没问题。
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 1) return result;

        // 连续序列最长为 Math.sqrt(sum >> 1)
        for (int n = (int) Math.sqrt(sum << 1); n >= 2; n--) {
            if (((n & 1) == 1 && sum % n == 0) || (sum % n << 1 == n)) {
                ArrayList<Integer> res = new ArrayList<>();
                for (int j = 0, val = sum / n - ((n - 1) >> 1); j < n; j++)
                    res.add(val++);
                result.add(res);
            }
        }

        return result;
    }

    @Test
    public void test() {
        int sum = 100;
        ArrayList<ArrayList<Integer>> res = findContinuousSequence(sum);
        System.out.println(res.toString());
        /*for (ArrayList<Integer> l : res)
            System.out.println(l.toString());*/
    }

}
