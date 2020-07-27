package com.search;

/**
 * 插入排序
 * 插值查找是对二分查找的优化，是有序序列的查找算法，插值查找和二分查找的区别在于对于mid的定位。
 * 二分查找公式：mid = (max + min) / 2
 * 插值查找公式：mid = min + (max - min) * (value - arr[min])/(arr[max] - arr[min])
 * 代码和折半查找一模一样，唯独mid的计算方式发生改变。这样的好处在于，对于数据量较大，
 * 数据分布比较均匀的查找而言，采用插值查找速度较快。但是如果数据分布不均，二分查找法不一定比插值查找法差。
 * 2020/7/17 0017
 */
public class InsertValSearch {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,5,6,7,8,9,10};
        int i = insertValSearch(arr, 5);
        System.out.println(i);
    }

    /**
     * 插入查找
     * @param arr 查找数组
     * @param value 查找值
     * @return 返回-1，则证明没找到，返回其他数证明找到
     */
    public static int insertSearch(int[] arr,int value) {
        // 查找值不能超过索引的最大元素
//        if (value > arr[arr.length - 1] || value < arr[0]) {
//            return -1;
//        }
        int min = 0;
        int max = arr.length - 1;
        while (true) {
            int mid = min + (max - min) * (value - arr[min]) / (arr[max] - arr[min]);
            if (arr[mid] < value) {
                min = mid + 1;
            } else if (arr[mid] > value) {
                max = mid - 1;
            } else {
                return  mid;
            }
            if (min > max) {
                return -1;
            }
        }
    }
    /**
     * 插值查找，会出现
     * @param arr 需要查找的数组
     * @param value 需要查找的元素值
     * @return 如果返回值为正数，则证明找到；如果返回-1，则证明没找到。
     */
    public static int insertValSearch(int[] arr, int value) {
        // 最小索引
        double min = 0;
        // 最大索引
        double max = arr.length - 1;
        // 处理查询的元素越界的情况
        if (arr[(int) min] > value || arr[(int)max] < value) {
            return -1;
        }
        //         int[] arr = {0,1,2,3,5,6,7,8,9,10};
        // 开始循环查找
        while(true) {
            // 获取中间索引 0 +(9-0)*(5-0)/(10-0)  =
            double mid = min + (max - min) * (value - arr[(int)min])/(arr[(int) max] - arr[(int) min]);
            // 如果arr[mid]>value,则证明在上半区
            if(arr[(int)mid] > value) {
                // 更新max的值
                max = mid - 1;
            }
            // 如果arr[mid]<value,则证明在下半区
            else if(arr[(int) mid] < value) {
                // 更新min的值
                min = mid + 1;
                System.out.println("mid:" + mid + " max:" + max + " min:" + min);
            }
            // 如果arr[mid]==value,则证明找到
            else {
                return (int) mid;
            }
            // 如果min>max,则证明没找到该值
            if(min > max) {
                return -1;
            }
        }
    }
}
