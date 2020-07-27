package com.aurthor;

/**
 * 数组模拟栈：顺序存储结构
 */
public class Stack {
    /**
     * 栈的大小
     */
    private int maxSize;
    /**
     * 数组
     */
    private Object[] stack;
    /**
     * 栈顶
     */
    private int top = -1;

    /**
     * 构造方法
     * @param maxSize 栈的储存容量
     */
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Object[maxSize];
    }

    /**
     * 判断栈是否满
     * @return true，栈满；false，未满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }
    /**
     * 判断栈是否空
     * @return true，栈空；false，未空
     */
    public boolean isEmapty() {
        return top == -1;
    }

    /**
     * 入栈
     * @param data 入栈元素
     */
    public void push(Object data) {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        top++;
        stack[top] = data;
    }

    /**
     * 出栈
     * @return 出栈元素
     */
    public Object pop() {
        if (isEmapty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    /**
     * 遍历打印栈的元素
     */
    public void print() {
        for (int i = 0; i < top; i++) {
            System.out.print(stack[i]+"\t");
        }
    }

    /**
     * 获取栈的容量大小
     * @return 容量大小
     */
    public int size() {
        return maxSize;
    }
}
