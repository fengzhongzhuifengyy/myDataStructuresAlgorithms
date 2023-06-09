package com.hw.od.exerciseB;

import java.util.Arrays;
import java.util.Scanner;

/**
    最佳植树距离
    题目描述
    按照环保公司要求，小明需要在沙化严重的地区进行植树防沙工作，
    初步目标是种植一条直线的树带。由于有些区域目前不适合种植树木，所以只能在一些可以种植的点来种植树木。
    在树苗有限的情况下，要达到最佳效果，就要尽量散开种植，不同树苗之间的最小间距要尽量大。
    给你一个适合种情树木的点坐标和一个树苗的数量，请帮小明选择一个最佳的最小种植间距。
    例如，适合种植树木的位置分别为1,3,5,6,7,10,13 树苗数量是3，
    种植位置在1,7,13，树苗之间的间距都是6，均匀分开，就达到了散开种植的目的，最佳的最小种植间距是6
    输入描述
    第1行表示适合种树的坐标数量
    第2行是适合种树的坐标位置
    第3行是树苗的数量
    例如：
    7
    1 5 3 6 10 7 13
    3
    输出描述
    最佳的最小种植间距
    备注
    位置范围为1~10000000
    种植树苗的数量范围2~10000000
    用例确保种桔的树苗数量不会超过有效种桔坐标数量
    用例
    输入
    7
    1 5 3 6 10 7 13
    3
    输出  6
    说明  3棵树苗分别种植在1，7，13位置时，树苗种植的最均匀，最小间距为6
 */
public class Main005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        System.out.println(getDistance(arr, m));
    }

    private static int getDistance(int[] arr, int m) {
        Arrays.sort(arr);

        int minLen = 0;
        int maxLen = arr[arr.length - 1] - arr[0];
        int res = 0;
        while (minLen <= maxLen) {
            int mid = (minLen + maxLen) / 2;
            if (isSure(arr, m, mid)) {
                res = mid;
                minLen = mid + 1;
            } else {
                maxLen = mid - 1;
            }

        }
        return res;
    }

    public static boolean isSure(int[] arr, int m, int distance) {
        int min = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min >= distance) {
                min = arr[i];
                count++;
            }
        }

        if (count >= m) {
            return true;
        }
        return false;
    }
}
