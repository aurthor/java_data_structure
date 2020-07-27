package com.search;

import java.util.Arrays;

/**
 * 斐波拉契查找
 * 2020/7/17 0017
 */
public class FibSearch {
    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24};
        // 调用斐波拉契查找，找到查找元素的索引
        int index = fibSearch(arr, 24);
        System.out.println(index);
    }
    /**
     * 构造一个斐波那契数组
     * @return
     */
    public static int[] fib() {
        final int MAX_SIZE = 20;
        // 数组长度为20，则fib[19]的值为6765
        int[] fib = new int[MAX_SIZE];
        // 构建斐波拉契数组
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i < MAX_SIZE; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
    /**
     * 黄金分割查找
     * @param arr 需要查找的数组
     * @param value 需要查找的元素值
     * @return 如果返回值为正数，则证明找到；如果返回-1，则证明没找到。
     */
    public static int fibSearch(int[] arr, int value) {
        // 保存数组arr的最小索引和最大索引
        int min = 0, max = arr.length - 1;
        // 保存黄金分割点的值
        int mid = 0;
        // 保存黄金分割的数值下标
        int k = 0;
        // 获得斐波拉契分割数值下标
        int[] fib = fib();
        while(arr.length > fib[k] - 1) {
            k++;
        }
        // 对原有数组进行扩容操作
        int[] tempArr = Arrays.copyOf(arr, fib[k]);
        // 把tempArr的[max + 1, tempArr.length - 1]区间的元素进行补充
        for(int i = max + 1; i < tempArr.length; i++) {
            tempArr[i] = arr[max];
        }
        // 如果min<=max，则进行循环查找
        while(min <= max) {
            // 获得黄金分割点
            mid = min + fib[k - 1] - 1;
            // 如果arr[mid]>value，则证明查找元素在黄金分割点左侧
            if(arr[mid] > value) {
                max = mid - 1;
                k = k - 1;
            }
            // 如果arr[mid]<value，则证明查找元素在黄金分割点右侧
            else if(arr[mid] < value) {
                min = mid + 1;
                k = k - 2;
            }
            // 如果arr[mid]==value，则证明找到value在数组中的索引值
            else {
                if(mid <= max)
                    return mid;
                    // 若mid>=max则说明是扩展的数值,返回max
                else
                    return max;
            }
        }
        // 执行到此处，证明value在数组中不存在
        return -1;
    }

}
