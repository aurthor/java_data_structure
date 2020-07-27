package com.demo;

import com.list.DoubleLinkedList;

/**
 * Administrator
 * 2020/7/12 0012
 */
public class Demo01 {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        for (int i = 0; i < 10; i++) {
            doubleLinkedList.add(i);
        }
        Object o = doubleLinkedList.get(0);
        System.out.println(doubleLinkedList.getSize());
        System.out.println(o);
        System.out.println(doubleLinkedList);

    }
}
