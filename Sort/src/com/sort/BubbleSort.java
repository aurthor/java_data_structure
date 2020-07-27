package com.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 1.执行每一趟相邻两个元素比较之前，先假设本趟判断已经排序成功。
 * 2.如果相邻两个元素比较的时候，发生前一个元素大于后一个元素，则推翻假设。
 * 3.每一趟相邻两个元素比较完毕后，如果假设依旧成立，则跳出外侧循环。
 * 2020/7/17 0017
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {12,34,1,56,54,8,32,656,78,4523};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));

    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
