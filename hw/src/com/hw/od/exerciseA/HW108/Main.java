package com.hw.od.exerciseA.HW108;

import java.util.ArrayList;
import java.util.Scanner;

/*
创建二叉树
题目描述
请按下列描述构建一颗二叉树，并返回该树的根节点：
1、先创建值为-1的根结点，根节点在第0层;
2、然后根据operations依次添加节点： operations[i] = [height, index] 表示对第 height 层的第index 个节点node， 添加值为 i 的子节点：
- 若node 无「左子节点」，则添加左子节点;
- 若node 有「左子节点」，但无「右子节点」，则添加右子节点；
- 否则不作任何处理。
height、index 均从0开始计数；
index 指所在层的创建顺序。
注意：
- 输入用例保证每次操作对应的节点已存在；
- 控制台输出的内容是根据返回的树根节点，按照层序遍历二叉树打印的结果。
输入描述
operations
输出描述
根据返回的树根节点，按照[层序遍历]二叉树打印的结果
备注
- 1 <= operations.length <= 100
- operations[i].length == 2
- 0 <= operations[i][0] < 100
- 0 <= operations[i][1] < 100
用例

| 输入 | [[0, 0], [0, 0], [1, 1], [1, 0], [0, 0]]                     |
| ---- | ------------------------------------------------------------ |
| 输出 | [-1, 0, 1, 3, null, 2]                                       |
| 说明 | 首个值是根节点的值，也是返回值；null 表示是空节点，此特殊层序遍历会遍历有值节点的 null 子节点 |

| 输入 | [[0, 0], [1, 0], [1, 0], [2, 1], [2, 1], [2, 1], [2, 0], [3, 1], [2, 0]] |
| ---- | ------------------------------------------------------------ |
| 输出 | [-1, 0, null, 1, 2, 6, 8, 3, 4, null, null, null, null, null, null, 7] |
| 说明 | 首个值是根节点的值，也是返回值；null 表示是空节点，此特殊层序遍历会遍历有值节点的 null 子节点 |
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 对str进行处理
        // [[0, 0], [0, 0], [1, 1], [1, 0], [0, 0]]
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                sb.append(chars[i]);
            }
        }
        String newStr = sb.toString();
        //System.out.println(newStr);
        Integer[][] arr = new Integer[newStr.length() / 2][2];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.valueOf(newStr.substring(index, index + 1));
                index++;
            }
        }
        //System.out.println(Arrays.deepToString(arr));
        getRes(arr);
    }

    private static void getRes(Integer[][] arr) {
        MainNode root = new MainNode(-1);
        ArrayList<MainNode> list = new ArrayList<>();
        list.add(root);
        ArrayList<ArrayList<MainNode>> tree = new ArrayList<>();
        tree.add(list);
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i][0];
            int index = arr[i][1];
            if (height +1 >= tree.size()){
                tree.add(new ArrayList<>());
            }
            MainNode node = new MainNode(i);
            MainNode faNode = tree.get(height).get(index);
            // 添加树
            if (faNode.leftNode == null || faNode.rightNode == null){
                tree.get(height+1).add(node);
            }
            //建立关联关系
            if (faNode.leftNode == null){
                faNode.leftNode = node;
            }else if(faNode.rightNode == null){
                faNode.rightNode = node;
            }
        }
    }
}

class MainNode {
    public int data;
    public MainNode leftNode;
    public MainNode rightNode;

    public MainNode(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
}