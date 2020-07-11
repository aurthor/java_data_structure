package com.demo;

import com.list.SequenceList;

/**
 * 找数组中重复的元素:
 *      在一个长度为n的数组里的所有元素都在[0, n-1]范围内。
 *      数组中某些元素是重复的，但不知道有几个元素是重复的，
 *      也不知道每个元素重复几次。请找出数组中任意一个重复的元素。
 *      例如，如果输入长度为6的数组{0, 2, 4, 1, 4, 3}，那么输出重复的元素4。
 * 2020/7/10 0010
 */
public class Demo02 {
    public static void main(String[] args) {

    }
    public static int getRepeatNumber(int[] arr) {
        //判断数组是否合法
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length;) {
            //判断数组元素是否合法
            if (arr[i] < 0 || arr[i] > arr.length) {
                return -1;
            }
            if (arr[i] == i) {
                i++;
            } else {
                if (arr[i] == arr[arr[i]]) {
                    return -1;
                } else {
                    int temp = arr[i];
                    arr[i] = arr[arr[i]];
                    arr[temp] = temp;
                }
            }
        }
        return -1;
    }
}
