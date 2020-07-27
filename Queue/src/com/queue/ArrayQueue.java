package com.queue;

/**
 * 使用数组模拟队列：顺序存储
 */
public class ArrayQueue {
    /**
     * 表示数据的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 存放数据，模拟队列
     */
    private Object[] arr;

    /**
     * 队列构造器
     * @param maxSize 数组容量
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new Object[maxSize];
        // 指向队列头部
        front = -1;
        // 指向队尾
        rear = -1;
    }

    /**
     * 判断队列是否满
     * @return true,代表队列已满；false，队列未满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     * @return true,代表队列为空；false，队列不为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加元素
     * @param object 添加的元素
     */
    public void addQueue(Object object) {
        // 判断是否满
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
        rear++;
        arr[rear] = object;
    }

    /**
     * 获取队列的元素
     * @return 元素
     */
    public Object getQueue() {
        // 判断是否为空
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        }
        front++;
        Object o = arr[front];
        arr[front] = null;
        return o;
    }

    /**
     * 显示所有元素
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"] = "+arr[i]);
        }
    }
}
