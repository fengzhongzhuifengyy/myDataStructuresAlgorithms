package com.hw.od.exerciseB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
求符合条件元组个数
知识点滑窗
时间限制：1s 空间限制：256MB 限定语言：不限
题目描述：
给定一个整数数组 nums 、一个数字k,一个整数目标值 target，请问nums中是否存在k个元素使得其相加结果为target，
请输出所有符合条件且不重复的k元组的个数
数据范围
2<= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
2 <= k <= 100
输入描述：
第一行是nums 取值：2 7 11 15
第二行是k的取值：2
第三行是target取值： 9
输出描述：
输出第一行是符合条件的元祖个数： 1
补充说明：
[2,7]满足，输出个数是1
示例1
输入：
-1 0 1 2 -1 -4
3
0
输出：
2
说明：
-1 0 1,-1 -1,2 满足条件
示例2
输入：
2 7 11 15
2
9
输出：
1
说明：
2 7 符合条件
 */

    public class Main010{

        public static int res = 0;
        public static int target;
        public static List<List<Integer>> numsList = new ArrayList<>();

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int k = sc.nextInt();
            target = sc.nextInt();

            combine( nums, k, new ArrayList<>(), 0);

            System.out.println(res);
        }

        /**
         * M中选其N个数
         * @param nums      数组
         * @param n         n个数
         * @param list      选取的数字
         * @param index     数组的索引
         */
        public static void combine(int[] nums, int n, List<Integer> list, int index){

            if(n == 0){
                int count = 0;
                for(Integer i : list){
                    count += i;
                }
                if(count == target && !isContain(list)){
                    //是否满足target的同时还需满足元素不重复的情况
                    numsList.add(new ArrayList<>(list));
                    res ++;
                }
            }else {
                for(int i=index; i<nums.length; i++){
                    list.add(nums[i]);
                    combine( nums, n -1, list, i+1);
                    list.remove(list.size() - 1);
                }
            }
        }

        /**
         * 是否包含集合
         * @param list
         * @return
         */
        public static boolean isContain(List<Integer> list){

            Collections.sort(list);
            for(List<Integer> l : numsList){
                Collections.sort(l);
                if(l.toString().equals(list.toString())){
                    return true;
                }
            }

            return false;
        }
    }

