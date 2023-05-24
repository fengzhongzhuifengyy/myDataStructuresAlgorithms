package com.hw.od.exerciseA.HW83;

import java.util.Scanner;

/*
    寻找符合要求的最长子串:
题目描述
给定一个字符串s，找出这样一个子串：

该子串中任意一个字符最多出现2次
该子串不包含指定某个字符
请你找出满足该条件的最长子串的长度

输入描述
第一行为：要求不包含的指定字符，为单个字符，取值范围[0-9a-zA-Z]

第二行为：字符串s，每个字符范围[0-9a-zA-Z]，长度范围[1, 10000]

输出描述
一个整数，满足条件的最长子串的长度；

如果不存在满足条件的子串，则返回0

用例
输入	D
        ABC132
输出	6
说明	无
输入	D
        ABACA123D
输出	7
说明	无
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = sc.nextLine().charAt(0);
        String s = sc.nextLine();
        
    }
}
