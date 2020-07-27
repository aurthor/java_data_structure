package com.demo;

/**
 * 节点类
 * 2020/7/18 0018
 */
public class Node {
    /**
     * 存放数据
     */
    public Object data;
    /**
     * 下个节点的地址
     */
    public Node next;

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
