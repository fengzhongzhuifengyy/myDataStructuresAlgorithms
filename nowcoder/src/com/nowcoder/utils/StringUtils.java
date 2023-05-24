package com.nowcoder.utils;

public class StringUtils {

    /**
     * 过滤字符串的空格和标点符号
     * @param s
     * @return String
     */
    public static String filterNoNumberAndChar(String s){
       return s.replaceAll("[^a-z0-9A-Z]]", "");
    }

    /**
     * 反转字符串
     * @param s
     * @return
     */
    public static String reverseString(String s){
        return new StringBuilder(s).reverse().toString();
    }
}
