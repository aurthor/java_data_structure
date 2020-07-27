package com.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 2020/7/17 0017
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] a = {12,34,1,56,54,8,32,656,78,4523};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            if (max != i) {
                int temp = arr[max];
                arr[max] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
