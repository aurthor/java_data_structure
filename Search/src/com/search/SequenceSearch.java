package com.search;

/**
 * 线性查找
 * 线性查找是一种最简单粗暴的查找法了，采用逐一比对的方式进行对数组的遍历，如果发现了匹配值，返回数组下标即可。
 * 线性查找，优点是查找数组无需有序；其缺点是查找的次数多，效率低下。
 * 2020/7/17 0017
 */
public class SequenceSearch {
    public static void main(String[] args) {
        int[] arr = {12,34,56,6,213,768,21,56,32};
        int index = seqSearch(arr, 1);
        System.out.println(index);
    }
    /**
     * 线性查找方法
     * @param arr 数组
     * @param value 查找数值
     * @return 索引值
     */
    public static int seqSearch(int[] arr,int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
