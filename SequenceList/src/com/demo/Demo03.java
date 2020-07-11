package com.demo;

import java.util.LinkedList;

/**
 * 使奇数位于偶数前面:
 *      输入一个整型数组，实现一个方法来调整该数组中的元素的顺序，
 *      使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 实现思路：
 *      1、创建一个新数组、数组长度为原始数组的长度
 *      2、遍历数组元素，如果是奇数就放在新数组索引为0的位置，依次增加，如果是偶数就放在新数组末尾，依次递减
 *
 * 2020/7/10 0010
 */
public class Demo03 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] ints = replaceIndex(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public static int[] replaceIndex(int[] arr) {
        //索引为0
        int begin = 0;
        //索引末尾
        int end = arr.length - 1;
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                newArr[end--] = arr[i];
            } else {
                newArr[begin++] = arr[i];
            }
        }
        return newArr;
    }
}
