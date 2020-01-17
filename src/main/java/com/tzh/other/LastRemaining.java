package com.tzh.other;

import org.junit.Test;

/**
 * @author Brent
 * @title: LastRemaining
 * @projectName Offer
 * @date 2019/9/26 9:33
 * @description: 孩子们的游戏(圆圈中最后剩下的数)
 *
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 如果没有小朋友，请返回-1
 *
 * 时间限制：1秒 空间限制：32768K
 */
public class LastRemaining {

    public int lastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        byte[] p = new byte[n];

        int lastIndex = 0;
        while (n > 1) {
            int index = (m - 1) % n;
            for (int i = lastIndex; i < n; i++) {
                while (i < n && p[i] == 1) i++;
                if (i < n && index == 0) {
                    p[i] = 1;
                    while (p[lastIndex % p.length] == 1) lastIndex++;
                    break;
                }
                index--;
            }
            n--;
        }
        for (int i = 0; i < p.length; i++) {
            if (p[i] != 1)
                return i;
        }

        return -1;
    }

    /**
     * 假设在N0=N的时候，第一次出列的孩子在队列中序号为K，那么这个孩子出列后，
     * 剩余N-1个孩子的序号是0,1,2….K-1, K+1,K+2,….N-1，
     * 这个序列要调整成N-K-1,N-K,N-K+1,…N-2, 0, 1, …,N-K-2，
     * 主要变化在：原来的K+1到N-1的每个序号减去（K+1），因为原来K+1的序号变成了0，
     * 原来的N-1就就变成了（N-1）-(K+1)=N-K-2,那么原来的0的序号变成了（N-K-1），
     * 那么原来的0到K-1的每个序号加上（N-K-1），因此原来的0变成了（N-K-1）。
     *
     * 数学规律总结：设置变化前有N个元素，出列小孩序号为K，那么K=（M-1）%N，
     * 设置剩余小孩调整前原始序号为X，那么重新调整后，新序号为f（X）=（X-K-1）%N,
     * 将K值带入：f(X)=X0=(X-(M-1)%N-1)%N=(X-M)%N,那么已知X0新序号推原序号就是X=（X0+M）%N
     *
     * @param n
     * @param m
     * @return
     */
    public int m(int n, int m) {
        if(n < 1 || m < 1) return -1;
        int last = 0;  //N=1时剩余小孩的新序号一定是0
        //反推回去
        // 最后一个出列的序号一定为 0
        // 原序号 = (新序号 + m) % n
        for(int i = 2; i <= n; i++)
            last = (last + m) % i;
        return last;
    }

    @Test
    public void test() {
        int n = 6;
        int m = 1;
        System.out.println(lastRemaining_Solution(n, m));
        System.out.println(m(n ,m));
    }

}
