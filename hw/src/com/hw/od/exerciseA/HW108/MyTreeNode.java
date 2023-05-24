package com.hw.od.exerciseA.HW108;

/*
    创建自己的tree类
 */
public class MyTreeNode {
    // 存放节点的值
    private String data;
    private MyTreeNode leftNode;
    private MyTreeNode rightNode;

    public MyTreeNode(String data, MyTreeNode leftNode, MyTreeNode rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public MyTreeNode(String data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public MyTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(MyTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public MyTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(MyTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
