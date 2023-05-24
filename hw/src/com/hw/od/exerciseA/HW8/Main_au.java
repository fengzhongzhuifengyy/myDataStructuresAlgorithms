package com.hw.od.exerciseA.HW8;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_au {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 获取字符数组的个数
        int m = sc.nextInt();
        // 记录字符数
        LinkedList<Integer> link = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            link.add(sc.nextInt());
        }

        System.out.println(getResult(link, m));
    }

    /*
        得到 等和子数组最小和
     */
    public static int getResult(LinkedList<Integer> link, int m) {
        // 降序排序
        link.sort((a, b) -> b - a);

        // 求数组字符的和
        int sum = 0;
        for (Integer ele : link) {
            sum += ele;
        }
        // 当k的值为最大可以被等和分隔时,就是最大的值
        while (m > 0) {
            LinkedList<Integer> link_cp = new LinkedList<>(link);
            System.out.println(link_cp);
            if (canPartitionMSubsets(link_cp, sum, m)) {
                return sum / m;
            }
            m--;
        }

        return sum;
    }

    public static boolean canPartitionMSubsets(LinkedList<Integer> link, int sum, int m) {
        if (sum % m != 0) return false;

        int subSum = sum / m;

        if (subSum < link.get(0)) return false;

        //    while (link.get(0) == subSum) { // 此段代码可能越界
        while (link.size() > 0 && link.get(0) == subSum) {
            link.removeFirst();
            m--;
        }

        int[] buckets = new int[m];
        return partition(link, 0, buckets, subSum);
    }

    public static boolean partition(LinkedList<Integer> link, int index, int[] buckets, int subSum) {
        if (index == link.size()) return true;

        int select = link.get(index);

        for (int i = 0; i < buckets.length; i++) {
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;
            if (select + buckets[i] <= subSum) {
                buckets[i] += select;
                if (partition(link, index + 1, buckets, subSum)) return true;
                buckets[i] -= select;
            }
        }

        return false;
    }
}
