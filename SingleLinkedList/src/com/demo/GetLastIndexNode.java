package com.demo;

/**
 * 查找单链表倒数第k个节点:
 * 这里需要声明两个指针，也就是first指针和second指针，
 * 并且设置他们的初始值都是单链表的首节点，然后让first指针往后移动k-1个位置，
 * 此时first和second就间隔了k-1个位置，然后整体向后移动这两个指针，直到first指针走到单链表的尾节点时
 * ，此时second指针所指向的位置就是倒数第k个节点的位置。
 */
public class GetLastIndexNode {
    public static void main(String[] args) {
        Node lastNode = new Node(55);
        Node node4 = new Node(44, lastNode);
        Node node3 = new Node(33, node4);
        Node node2 = new Node(22, node3);
        Node headNode = new Node(11, node2);
        print(headNode);
        Node lastIndexNode = getLastIndexNode(headNode, 2);
        System.out.println(lastIndexNode.getData());
    }
    public static Node getLastIndexNode(Node headNode,int index) {
        Node first = headNode;
        Node second = headNode;
        for (int i = 0; i < index; i++) {
            first = first.getNext();
        }
        while (first != null) {
            first = first.getNext();
            second = second.getNext();
        }
        return second;
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
        System.out.println();
    }
}
