package com.hw.od.exerciseB;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 数字反转打印
 * 知识点枚举
 * 时间限制：1s 空间限制：256MB 限定语言：不限
 * 题目描述：
 * 小华是个很有对数字很敏感的小朋友，他觉得数字的不同排列方式有特殊美感。某天，小华突发奇想，如果数字多行排列，
 * 第一行1个数，第二行2个，第三行3个，即第n行有n个数字，并且奇数行正序排列，偶数行逆序排列，数字依次累加。
 * 这样排列的数字一定很有意思。聪明的你能编写代码帮助小华完成这个想法吗？
 * 规则总结如下：
 * a、每个数字占据4个位置，不足四位用‘*’补位，如1打印为1***。
 * b、数字之间相邻4空格。
 * c、数字的打印顺序按照正序逆序交替打印,奇数行正序，偶数行逆序。
 * d、最后一行数字顶格，第n-1行相对第n行缩进四个空格
 * 输入描述:
 * 第一行输入为N，表示打印多少行; 1<=N<=30
 * 输入：2
 * 输出描述:
 * XXXX1***
 * 3***XXXX2***
 * 补充说明：
 * 符号*表示，数字不满4位时的补位，符号X表示数字之间的空格。注意实际编码时不需要打印X，直接打印空格即可。此处为说明题意，故此加上X
 * 示例1
 * 输入：
 * 2
 * 输出：
 * 1***
 * 3***    2***
 */
public class Main009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getResult(n);
    }

    private static void getResult(int n) {
        /*
            整体思路: 一行一行处理, 不要想一下子打印太多
            按照题意来处理各种特殊限制
         */
        int firstNum = 1;
        // 为了方便从1开始计数. 打印n行
        for (int i = 1; i <= n; i++) {
            // 建立每一行的临时存储数据的数组
            int[] tempArr = new int[i];
            // 实际存储的数
            for (int j = 0; j < i; j++) {
                tempArr[j] = firstNum;
                // 下一行会接着上一行的数进行打印,所以++
                firstNum++;
            }
            // c、数字的打印顺序按照正序逆序交替打印,奇数行正序，偶数行逆序。
            if (i % 2 == 0) {
                // 进行取反打印
                reverse(tempArr);
            }
            // b、数字之间相邻4个空格。
            StringJoiner sj = new StringJoiner("    ");
            for (int ele : tempArr) {
                StringBuilder sb = new StringBuilder(ele + "");
                //a、每个数字占据4个位置，不足四位用‘*’补位，如1打印为1***。
                while (sb.length() < 4) {
                    sb.append("*");
                }
                sj.add(sb);
            }

            StringBuilder res = new StringBuilder(sj.toString());
            //d、最后一行数字顶格，第n-1行相对第n行缩进四个空格
            for (int k = 0; k < n - i; k++) {
                res.insert(0, "    "); // 缩进
            }
            System.out.println(res);
        }

    }

    // 交换
    public static void reverse(int[] tempArr) {
        int l = 0;
        int r = tempArr.length - 1;
        while (l <= r) {
            int temp = tempArr[l];
            tempArr[l] = tempArr[r];
            tempArr[r] = temp;
            l++;
            r--;
        }
    }


}
