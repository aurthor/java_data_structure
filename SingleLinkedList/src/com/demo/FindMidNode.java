package com.demo;

/**
 * 查找单链表的中间节点:
 * 要求不允许获得链表的长度，从而获得单链表的中间节点。如果链表的长度为偶数，返回中间两个节点的任意一个；若为奇数，则返回中间节点。
 * 思路分析:
 * 设置两个指针fast和slow并设置默认值为首节点，然后两个指针同时往后走，fast指针每次走两步，
 * slow指针每次走一步，直到fast指针走到最后一个节点时，此时slow指针所指的节点就是中间节点。
 * 注意链表为空和链表节点个数为1的情况。
 */
public class FindMidNode {
    public static void main(String[] args) {
        // 创建一个单链表
        Node lastNode = new Node(6);
        Node node5 = new Node(5, lastNode);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
//        Node headNode = new Node(1, node2);
        System.out.println("链表：");
        print(node2);
        Node midNode = getMidNode(node2);
        System.out.println("中间元素："+midNode.getData());

    }
    public static Node getMidNode(Node headNode) {
        Node slow = headNode;
        Node fast = headNode;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
    /**
     * 打印方法
     * @param headNode 头结点
     */
    public static void print(Node headNode) {
        // 定义临时节点用于循环遍历
        Node temp = headNode;
        while (temp != null) {
            System.out.print(temp.getData()+"\t");
            temp = temp.getNext();
        }
    }
}
