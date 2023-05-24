package com.hw.od.exerciseA.HW108;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Integer[][] operations =
                Arrays.stream(str.substring(1, str.length() - 1).split("(?<=]), (?=\\[)"))
                        .map(
                                s ->
                                        Arrays.stream(s.substring(1, s.length() - 1).split(", "))
                                                .map(Integer::parseInt)
                                                .toArray(Integer[]::new))
                        .toArray(Integer[][]::new);

        System.out.println(Arrays.deepToString(operations));
        //System.out.println(getResult(operations));
    }

    public static String getResult(Integer[][] operations) {
        Node head = new Node(-1);

        ArrayList<Node> level0 = new ArrayList<>();
        level0.add(head);

        ArrayList<ArrayList<Node>> tree = new ArrayList<>();
        tree.add(level0);

        for (int i = 0; i < operations.length; i++) {
            int height = operations[i][0];
            int index = operations[i][1];

            if (tree.size() <= height + 1) {
                tree.add(new ArrayList<>());
            }

            Node ch = new Node(i);

            Node fa = tree.get(height).get(index);
            // 注意，tree用于记录树中加入成功的节点是第几行第几个创建的，对于加入的失败的不应该记录
            if (fa.lc == null || fa.rc == null) {
                tree.get(height + 1).add(ch);
            }

            if (fa.lc == null) fa.lc = ch;
            else if (fa.rc == null) fa.rc = ch;
        }

        LinkedList<Integer> ans = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(tree.get(0).get(0));

        while (queue.size() > 0) {
            Node node = queue.removeFirst();

            if (node != null) {
                ans.add(node.val);
                queue.add(node.lc);
                queue.add(node.rc);
            } else {
                ans.add(null);
            }
        }

        while (true) {
            if (ans.getLast() == null) ans.removeLast();
            else break;
        }

        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (Integer an : ans) {
            sj.add(an + "");
        }

        return sj.toString();
    }
}

class Node {
    int val;
    Node lc;
    Node rc;

    public Node(int val) {
        this.val = val;
        this.lc = null;
        this.rc = null;
    }
}
