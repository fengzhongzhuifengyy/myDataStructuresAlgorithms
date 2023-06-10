package com.hm.code.stu01_binarySearch;

public class BinarySearch {
    
    /**
     * 二分查找基础版
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到返回索引值, 未找到返回-1
     */
    public static int BinarySearchBasic(int[] a, int target) {
        // 设置指针和初值
        int i = 0;
        int j = a.length - 1;
        while (i <= j) { // 范围内有数值
            int mid = (i + j) >>> 1;
            if (target < a[mid]) { // 目标在左边
                j = mid - 1;
            } else if (a[mid] < target) { // 目标在右边
                i = mid + 1;
            } else { // 找到了
                return mid;
            }

        }
        return -1;
    }

    /*
        1. 为什么i <= j 意味着有元素,而不是i < j?
        --- i与j 他们指向的元素也会参与比较

        2. int mid = (i + j) / 2 有没有问题呢?
        --- 如果j=Integer.MAX_VALUE, 此时会发生溢出问题
            建议改为 无符号右移1位

        3. 都写成小于号有什么好处?
        --- 数组是升序的, 方便理解代码
     */

    /**
     * 二分查找改动版
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return 找到返回索引值, 未找到返回-1
     */
    public static int BinarySearchAlternative(int[] a, int target) {
        int i = 0;
        int j = a.length; // 第一处改动, 改动都依赖于j的指针位置.此处的j不会进行比较
        while (i < j) { // 第二处改动
            int mid = (i + j) >>> 1;
            if (target < a[mid]) {
                j = mid; // 第三处改动
            } else if (a[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
