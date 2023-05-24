package com.hw.od.exerciseA.HW4;

import java.util.Scanner;

/*
    最小覆盖子串: 求s中包含t字符的最小子串
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(getMinLen(s, t));
    }

    private static String getMinLen(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        //定义两个词频数组
        int[] sArr = new int[128];
        int[] tArr = new int[128];
        // 将t中的字符数归档到词频数组中
        char[] tCh = t.toCharArray();
        char[] sCh = s.toCharArray();
        for (char ch : tCh) {
            tArr[ch] += 1;
        }

        int left = 0;
        int right = 0;
        int minLen = sLen +1;
        // 表示窗口中包含t字符串的字符数目, 如果同一字符包含所有的数目大于t中的数目,distance不变
        int distance = 0;
        // 最小子串的开始索引
        int begin = 0;
        // 右移
        while (right < sLen){
            if (tArr[s.charAt(right)] == 0){
                right++;
                continue;
            }
            if (sArr[s.charAt(right)] < tArr[s.charAt(right)]){
                distance++;
            }
            sArr[s.charAt(right)]++;
            right++;
            // 左移
            while (distance == t.length()){
                if (right- left < minLen){
                    minLen = right -left;
                    begin = left;
                }
                if (tArr[s.charAt(left)] == 0){
                    left++;
                    continue;
                }
                if (sArr[s.charAt(left)] ==  tArr[s.charAt(left)]){
                    distance--;
                }
                sArr[s.charAt(left)]--;
                left++;
            }
        }
        if (minLen == sLen +1){
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}
