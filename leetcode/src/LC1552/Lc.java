package LC1552;

import java.util.Arrays;

/**
 * 1552 两球之间的磁力
 * 题目描述
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，
 * 它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，
 * Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 * 示例
 * 输入	position = [1,2,3,4,7], m = 3
 * 输出	3
 * 说明	将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
 * 输入	position = [5,4,3,2,1,1000000000], m = 2
 * 输出	999999999
 * 说明	我们使用位于 1 和 1000000000 的篮子时最小磁力最大。
 * 提示
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * 所有 position 中的整数 互不相同 。
 * 2 <= m <= position.length
 */
public class Lc {
    public static void main(String[] args) {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(maxInstance(position, 3));
    }

    public static int maxInstance(int[] position, int m) {
        Arrays.sort(position);

        int minIns = 0;
        int maxIns = position[position.length - 1] - position[0];
        int ans = 0;

        while (minIns <= maxIns) {
            int mid = (minIns + maxIns) / 2; // 二分法,假设初始的解在mid
            if (isSure(position, m, mid)) {// 如果mid满足,说明mid是其中一个解但不一定是最优解,说明最优解可能在mid-maxIns之间
                // 记录当前mid为最优解
                ans = mid;
                minIns = mid + 1;
            } else { // 否则就说明mid不是解,放不下m,那么最优解一定在minIns - mid之间
                maxIns = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isSure(int[] position, int m, int distance) {
        //假设第一位放了一个为起始值
        int start = position[0];
        // 记录放入的球的数量
        int count = 1;

        //遍历position[],发现>=distance时,说明可以放入一个球了
        for (int i = 1; i < position.length; i++) {
            if (position[i] - start >= distance) {
                start = position[i]; // 起始值右移,再次进行计算
                count++;
            }
        }
        // 当count数大于等于需要的球的数量,说明在distance间距是可以放下的
        if (count >= m) {
            return true;
        }
        return false;
    }
}
