package com.hw.od.exerciseB;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 计算最大乘积
 * 知识点字符串位运算
 * 时间限制：1s 空间限制：32MB 限定语言：不限
 * 题目描述：
 * 给定一个元素类型为小写字符串的数组，请计算两个没有相同字符的元素 长度乘积的最大值，如果没有符合条件的两个元素，返回0。
 * 输入描述：
 * 输入为一个半角逗号分隔的小写字符串的数组，2 <= 数组长度<=100，0 < 字符串长度<= 50。
 * 输出描述：
 * 两个没有相同字符的元素 长度乘积的最大值。
 * 示例1
 * 输入：
 * iwdvpbn,hk,iuop,iikd,kadgpf
 * 输出：
 * 14
 * 说明：
 * 数组中有5个元素。
 * iwdvpbn与hk无相同的字符，满足条件，iwdvpbn的长度为7，hk的长度为2，乘积为14（7*2）。
 * iwdvpbn与iuop、iikd、kadgpf均有相同的字符，不满足条件。
 * iuop与iikd、kadgpf均有相同的字符，不满足条件。
 * iikd与kadgpf有相同的字符，不满足条件。
 * 因此，输出为14。
 */
public class Main007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        System.out.println(getRes(strs));
    }

    private static int getRes(String[] strs) {
//每一轮都需要清理, 或者每一轮重新生产一个新的set
        // 利用set集合的去重原理
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < strs.length; i++) {

            String s1 = strs[i];
            int len1 = s1.length();
            for (int j = 0; j < len1; j++) {
                set.add(s1.charAt(j));
            }
            for (int k = i + 1; k < strs.length; k++) {

                String s2 = strs[k];
                int len2 = s2.length();
                for (int l = 0; l < len2; l++) {
                    set.add(s2.charAt(l));
                }
                System.out.println(set);
                if (set.size() == len1 + len2) {
                    max = Math.max(max, len1 * len2);
                }
                set.clear();
            }

        }
        return max;
    }
}
