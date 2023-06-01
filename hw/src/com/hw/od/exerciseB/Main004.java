package com.hw.od.exerciseB;

/*
    报文回路
    题目描述
    IGMP 协议中响应报文和查询报文，是维系组播通路的两个重要报文，
    在一条已经建立的组播通路中两个相邻的 HOST 和 ROUTER，ROUTER 会给 HOST 发送查询报文，
    HOST 收到查询报文后给 ROUTER 回复一个响应报文，以维持相之间的关系，
    一旦这关系断裂，那么这条组播通路就异常”了。现通过某种手段，
    抓取到了 HOST 和 ROUTER 两者通讯的所有响应报文和查询报文，请分析该组播通路是否“正常”
    输入描述
    第一行抓到的报文数量C (C≤100) ，后续C行依次输入设备节点D1和D2，表示从D1到D2发送了单向的报文，D1和D2用空格隔开。
    输出描述
    组播通路是否“正常”，正常输出True， 异常输出False。
    用例
    输入
    5
    1 2
    2 3
    3 2
    1 2
    2 1
    输出	True
    说明	无
    输入
    3
    1 3
    3 2
    2 3
    输出	False
    说明	无
 */
public class Main004 {
    public static void main(String[] args) {

    }
}
