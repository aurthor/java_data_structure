package com.list;
import java.util.Arrays;

/**
 * 线性表的顺序存储的实现，模拟ArrayList
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
     * 默认的构造方法：构造长度为10的数组
     */
    public SequenceList() {
        data  = new Object[10];
    }

    /**
     * 构建一个长度为initialCapacity的顺序表
     * @param initialCapacity 初始化容量
     */
    public SequenceList(int initialCapacity) {
        // 判断长度是否合法
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("容量不合法:"+initialCapacity);
        }
        data = new Object[initialCapacity];
    }
    /**
     * 添加元素
     * @param element 添加的元素
     */
    public void add(Object element) {
        // 检查是否需要扩容
        checkOpacity();
        data[size++] = element;
    }

    /**
     * 获取索引位置的值
     * @param index 索引
     * @return 索引位置的值
     */
    public Object get(int index) {
        // 检查索引是否合法
        rangeCheck(index);
        return data[index];
    }

    /**
     * 删除索引位置的值
     * @param index 索引
     */
    public void remove(int index) {
        // 检查索引是否合法
        rangeCheck(index);
        // 数组拷贝
        System.arraycopy(data,index+1,data,index,size-1-index);
        size--;
    }

    /**
     * 在索引位置插入元素
     * @param index 索引
     * @param element 元素
     */
    public void add(int index,Object element) {
        rangeCheck(index);
        checkOpacity();
        System.arraycopy(data,index,data,index+1,size-index);
        data[index] = element;
        size++;
    }
    /**
     * 检查索引是否合法
     * @param index 索引
     */
    public void rangeCheck(int index) {
        if (index < 0 || index >size) {
            throw new IndexOutOfBoundsException("索引不合法："+index);
        }
    }

    /**
     * 判断是否需要扩容
     */
    public void checkOpacity() {
        if (data.length == size) {
            Object[] objects = new Object[data.length+data.length/2];
            System.arraycopy(data,0,objects,0,size);
            data = objects;
        }
    }

    @Override
    public String toString() {
        return "SequenceList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}

