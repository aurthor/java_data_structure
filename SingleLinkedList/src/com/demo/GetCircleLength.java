package com.demo;

/**
 * 从有环链表中，获得环的长度
 * 2020/7/18 0018
 */
public class GetCircleLength {
    public static void main(String[] args) {
        // 1.创建一个单链表
        Node lastNode = new Node(66);
        Node node5 = new Node(55, lastNode);
        Node node4 = new Node(44, node5);
        Node node3 = new Node(33, node4);
        Node node2 = new Node(22, node3);
        Node headNode = new Node(11, node2);
        lastNode.setNext(node2);
        // 2.从有环链表中，获得环的长度
        int size = getSize(headNode);
        System.out.println(size);
    }

    /**
     * 获取快慢指针的相交节点
     * @param headNode 首节点
     * @return 有环返回快慢指针的相遇节点，没环返回null
     */
    public static Node getMeetNode(Node headNode) {
        if (headNode == null) {
            return null;
        }
        Node slow = headNode;
        Node fast = headNode;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return fast;
            }
        }
        return null;
    }

    /**
     * 获取链表环的长度
     * @param headNode 首节点
     * @return 环的长度
     */
    public static int getSize(Node headNode) {
        if (headNode == null) {
            return 0;
        }
        Node meetNode = getMeetNode(headNode);
        if (meetNode == null) {
            return 0;
        }
        int size = 0;
        Node tempNode = meetNode;
        while (true) {
            tempNode = tempNode.getNext();
            size++;
            if (tempNode == meetNode) {
                break;
            }
        }
        return size;
    }
}
