package com.queue;

/**
 * Administrator
 * 2020/7/23 0023
 */
public class Test {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(4);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(4);
        arrayQueue.showQueue();
        Object queue = arrayQueue.getQueue();
        Object queue1 = arrayQueue.getQueue();
        arrayQueue.showQueue();
    }
}
