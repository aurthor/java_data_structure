package com.demo;

/**
 * 合并两个有序的单链表
 */
public class MergeList {
    public static void main(String[] args) {
        Node node1_4 = new Node(6);
        Node node1_3 = new Node(5, node1_4);
        Node node1_2 = new Node(3, node1_3);
        Node node1_1 = new Node(1, node1_2);

        Node node2_4 = new Node(8);
        Node node2_3 = new Node(7, node2_4);
        Node node2_2 = new Node(4, node2_3);
        Node node2_1 = new Node(2, node2_2);
        Node node = merageList(node1_1, node2_1);
        print(node);

    }
    public static Node merageList(Node headNode1,Node headNode2) {
        if (headNode1 == null && headNode2 == null) {
            return null;
        }
        if (headNode1 == null) {
            return headNode2;
        }
        if (headNode2 == null) {
            return headNode1;
        }
        Node headNode = null,lastNode = null;
        if (headNode1.data > headNode2.data) {
            headNode = headNode2;
            lastNode = headNode2;
            headNode2 = headNode2.next;
        } else {
            headNode = headNode1;
            lastNode = headNode1;
            headNode1 = headNode1.next;
        }
        while (headNode1 != null && headNode2 != null) {
            if (headNode1.data > headNode2.data) {
                lastNode.next = headNode2;
                lastNode = headNode2;
                headNode2 = headNode2.next;
            } else {
                lastNode.next = headNode1;
                lastNode = headNode1;
                headNode1 = headNode1.next;
            }
        }
        if (headNode1 == null) {
            lastNode.next = headNode2;
        } else {
            lastNode.next = headNode1;
        }
        return headNode;
    }
    /**
     * 打印方法
     * @param headNode 头结点
     */
    public static void print(Node headNode) {
        // 定义临时节点用于循环遍历
        Node temp = headNode;
        while (temp != null) {
            System.out.print(temp.data+"\t");
            temp = temp.next;
        }
    }
    private static class Node {

        /**
         * 用于保存节点中的数据
         */
        private int data;
        /**
         * 用于保存下一个节点的地址值
         */
        private Node next;

        /**
         * 专门为data做初始化的工作
         * @param data
         */
        public Node(int data) {
            this.data = data;
        }

        /**
         * 专门为data和next做初始化的工作
         * @param data
         * @param next
         */
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
