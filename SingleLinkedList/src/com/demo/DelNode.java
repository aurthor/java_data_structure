package com.demo;

/**
 * 在O(1)时间删除单链表节点:
 * 提供单链表的首节点和删除节点，定义一个方法在O(1)时间删除该节点。
 */
public class DelNode {
    public static void main(String[] args) {
        // 创建一个单链表
        Node lastNode = new Node(6);
        Node node5 = new Node(5, lastNode);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
//        Node headNode = new Node(1, node2);
        Node node = delNode(node2, node2);
        System.out.println("链表：");
        print(node);
    }

    /**
     * 删除节点
     * @param headNode 头结点
     * @param delNode 删除节点
     * @return 删除节点后的头节点
     */
    public static Node delNode(Node headNode,Node delNode) {
        if (headNode == null || delNode == null) {
            throw new NullPointerException("headNode或delNode为null");
        }
        if (headNode == delNode) {
            headNode = headNode.getNext();
            return headNode;
        } else if (delNode.getNext() == null) {
            Node temp = headNode;
            while (temp.getNext() != delNode) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            return headNode;
        } else {
            Node nextNode = delNode.getNext();
            delNode.setData(nextNode.getData());
            delNode.setNext(nextNode.getNext());
            nextNode.setNext(null);
            return headNode;
        }
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
