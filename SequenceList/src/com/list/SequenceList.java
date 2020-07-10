package com.list;

/**
 * 顺序表的实现，模拟ArrayList
 * 2020/7/10 0010
 */
public class SequenceList {
    /**
     * 存放数据的数组
     */
    private Object[] data;
    /**
     * 顺序表的长度
     */
    private int size;

    /**
     * 默认的构造方法：构造长度为10
     */
    public SequenceList() {
        data  = new Object[10];
    }

    /**
     * 构建一个长度为initialCapacity的顺序表
     * @param initialCapacity
     */
    public SequenceList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("容量不合法:"+initialCapacity);
        }
        data = new Object[initialCapacity];
    }

    /**
     * 添加元素
     * @param element
     */
    public void add(Object element) {
        rangeCheckForAdd(size);
        data[size++] = element;
    }

    /**
     * 检查索引是否合法
     * @param index
     */
    public void rangeCheckForAdd(int index) {
        if (index < 0 || index >size) {
            throw new IndexOutOfBoundsException("索引不合法："+index);
        }
    }

    /**
     * 判断是否需要扩容
     */
    public void checkOpacity() {

    }
}

