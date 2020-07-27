package com.demo;

/**
 * 单链表的反转
 */
public class ReverseNode {
    public static void main(String[] args) {
        // 创建一个单链表
        Node lastNode = new Node(4);
        Node node3 = new Node(3, lastNode);
        Node node2 = new Node(2, node3);
        Node headNode = new Node(1, node2);
        System.out.println("反转之前：");
        print(headNode);
        System.out.println();
        System.out.println("反转之后：");
        Node reverse = reverse(headNode);
        print(reverse);
    }

    /**
     * 反转链表
     * @param headNode 头结点
     */
    public static Node reverse(Node headNode) {
        if (headNode == null || headNode.getNext() == null) {
            return headNode;
        }
        Node last = null;
        while (headNode != null) {
            Node next = headNode.getNext();
            headNode.setNext(last);
            last = headNode;
            headNode = next;
        }
        return last;
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
