package com.hw.od.exerciseA.HW108;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MyTreeTest {
    public static void main(String[] args) {

        // 创建树节点的关联关系
        // 假设以ABCDEFG为例
        MyTreeNode treeNodeA = new MyTreeNode("A");
        MyTreeNode treeNodeB = new MyTreeNode("B");
        MyTreeNode treeNodeC = new MyTreeNode("C");
        MyTreeNode treeNodeD = new MyTreeNode("D");
        MyTreeNode treeNodeE = new MyTreeNode("E");
        MyTreeNode treeNodeF = new MyTreeNode("F");
        MyTreeNode treeNodeG = new MyTreeNode("G");
        treeNodeA.setLeftNode(treeNodeB);
        treeNodeA.setRightNode(treeNodeC);
        treeNodeB.setLeftNode(treeNodeD);
        treeNodeB.setRightNode(treeNodeE);
        treeNodeC.setLeftNode(treeNodeF);
        treeNodeC.setRightNode(treeNodeG);

        //preSort(treeNodeA);
        //System.out.println("=========");
        //minSort(treeNodeA);
        //System.out.println("=========");
        //lastSort(treeNodeA);
        //System.out.println("=========");
        preOrderSort(treeNodeA);

    }

    // 层序遍历
    private static void preOrderSort(MyTreeNode node) {
        Queue<MyTreeNode> queue = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        if (node == null){
            return;
        }
        queue.offer(node);
        while (!queue.isEmpty()){
            MyTreeNode polNode = queue.poll();
            list.add(polNode.getData());
            if (polNode.getLeftNode() != null){
                 queue.offer(polNode.getLeftNode());
            }
            if (polNode.getRightNode() != null){
                queue.offer(polNode.getRightNode());
            }
        }
        System.out.println(list);
    }
    // 左右中
    private static void lastSort(MyTreeNode node) {

        if (node == null){
            return;
        }

        lastSort(node.getLeftNode());
        lastSort(node.getRightNode());
        System.out.println(node.getData());
    }
    // 左 中 右
    private static void minSort(MyTreeNode node) {
        if (node == null){
            return;
        }

        minSort(node.getLeftNode());
        System.out.println(node.getData());
        minSort(node.getRightNode());
    }

    // 中 左 右
    private static void preSort(MyTreeNode node) {
        if (node == null){
            return;
        }
        System.out.println(node.getData());
        preSort(node.getLeftNode());
        preSort(node.getRightNode());
    }


}
