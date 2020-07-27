package com.search;

/**
 * 二分查找
 * 只能用于有序列表中
 * 2020/7/17 0017
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {12,14,16,18,20,22,24,26,28,30};
        int i = binarySearch(arr, 34);
        System.out.println(i);
    }

    /**
     * 二分查找方法
     * @param arr 要查找的数组
     * @param value 要查找的值
     * @return 找到返回索引，没有返回-1
     */
    public static int binarySearch(int[] arr,int value) {
        int begin = 0;
        int end = arr.length - 1;
        while (true) {
            int mid = (begin + end) / 2;
            if (arr[mid] > value) {
                end = mid - 1;
            } else if (arr[mid] < value) {
                begin = mid + 1;
            } else {
                return mid;
            }
            if (begin > end) {
                return -1;
            }
        }
    }
}
