package com.hw.od.exerciseA.HW8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


/**
 * 等和子数组最小和
 * <p>
 * 题目描述
 * 给定一个数组nums，将元素分为若干个组，使得每组和相等，求出满足条件的所有分组中，组内元素和的最小值。
 * 输入描述
 * 第一行输入 m
 * 接着输入m个数，表示此数组nums
 * 数据范围：1<=m<=50, 1<=nums[i]<=50
 * 输出描述
 * 最小拆分数组和
 * 用例
 * 输入	7
 * 4 3 2 3 5 2 1
 * 输出	5
 * 说明
 * 可以等分的情况有：
 * 4 个子集（5），（1,4），（2,3），（2,3）
 * 2 个子集（5, 1, 4），（2,3, 2,3）
 * 但最小的为5。
 */
public class Main {
    public static void main(String[] args) {
        /*
            先判断k个数能不能被区分
         */
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            arrayList.add(sc.nextInt());
        }
        System.out.println(getSum(arrayList, num));

    }

    private static int getSum(ArrayList<Integer> arrayList, int num) {
        int sum = 0;
        for (Integer integer : arrayList) {
            sum += integer;
        }

        while (num > 0){
            if (isQuFen(arrayList, sum, num)){
                return sum / num;
            }
            num--;
        }
        return sum;
    }

    private static boolean isQuFen(ArrayList<Integer> arrayList, int sum, int num) {

        if (sum % num != 0) {
            return false;
        }

        int ziSum = sum / num;
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        if (ziSum < arrayList.get(0)) {
            return false;
        }
        int[] tong = new int[num];

        return huiSu(arrayList, 0, tong, num, ziSum);
    }


    private static boolean huiSu(ArrayList<Integer> arrayList, int index, int[] tong,
                                 int num, int ziSum) {
        if (index == tong.length) {
            return true;
        }
        int res = arrayList.get(index);
        // 遍历num个桶
        for (int i = 0; i < tong.length; i++) {
            if (res == ziSum || res + tong[i] <= ziSum) {
                tong[i] += res;
                if (huiSu(arrayList, index + 1, tong,
                        num, ziSum)) {
                    return true;
                }
                tong[i] -= res;
            }
        }
        return false;
    }
}
