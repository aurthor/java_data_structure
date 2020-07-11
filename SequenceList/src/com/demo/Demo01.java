package com.demo;

/**
 * 数组的反转
 * 方案一：
 *      引入一个外部数组变量，用于保存反序后的数组，
 *      然后把原数组中的元素倒序保存于新创建的数组中，
 *      新建数组保存的元素就是反转之后的结果。
 * 方案二：
 *      接对数组中的元素进行收尾交换。
 *      这样避免了新建一个数组来保存反转之后的结果，
 *      并且循环遍历的次数也降为“实现方案一”的一半，从而提高了算法的效率。
 * 2020/7/10 0010
 */
public class Demo01 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int[] reverseArray = reverseArray1(array);

    }
    public static int[] reverseArray1(int[] array) {
        int[] reverseArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverseArray[array.length-1-i] = array[i];
        }
        return reverseArray;
    }
    public static void reverseArray2(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i];
        }
    }
}
