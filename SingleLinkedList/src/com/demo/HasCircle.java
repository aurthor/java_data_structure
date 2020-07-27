package com.demo;

/**
 * 判断单链表是否有环
 * 这里也是用到两个指针，如果一个链表有环，那么用一个指针去遍历，是永远走不到头的。
 * 因此，我们用两个指针去遍历：slow指针每次走一步，fast指针每次走两步，如果slow指针和fast指针相遇，则证明单链表中有环。
 */
public class HasCircle {
    public static void main(String[] args) {
        // 1.创建一个单链表
        Node lastNode = new Node(55);
        Node node4 = new Node(44, lastNode);
        Node node3 = new Node(33, node4);
        Node node2 = new Node(22, node3);
        Node headNode = new Node(11, node2);
        lastNode.setNext(node2);
        boolean b = hasCircle(headNode);
        System.out.println(b);
    }

    /**
     * 判断是否有环
     * @param headNode 头结点
     * @return true代表有，false没有
     */
    public static boolean hasCircle(Node headNode) {
        if (headNode == null) {
            return false;
        }
        Node slow = headNode;
        Node fast = headNode;
        while (fast != null && fast.next != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;

            }
        }
        return false;
    }
}
