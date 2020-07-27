package com.aurthor;

/**
 * 测试方法
 */
public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        System.out.println(stack.isFull());
        for (int i = 0; i < stack.size(); i++) {
            stack.push(i);
        }
        stack.print();
        System.out.println();
        for (int i = 0; i < 5; i++) {
            stack.pop();
        }
        stack.print();
    }
}
