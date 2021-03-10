package main.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author: LinKai
 * @time: 2021/2/10-10:11
 */

public class MergeSort {

    /**
     * 临时数组在方法外开辟，不然每一次merge都要开数组
     */
    private static int[] temp;

    public static void main(String[] args) {
        int[] data = {5, 6, 2, 8, 3, 9, 0, 5};
        mergeSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 思路：归并排序（使用递归）
     *
     * @param data
     * @param left  数组最左端
     * @param right 数组最右端
     */
    public static void mergeSort(int[] data, int left, int right) {
        // 将数组拆分到只剩一个数
        if (left < right) {
            int mid = (left + right) / 2;
            // 左边部分
            mergeSort(data, left, mid);
            // 右边部分
            mergeSort(data, mid + 1, right);
            // 分完之后进行合并排序
            merge(data, left, mid, right);
        }
    }

    /**
     * 并的过程：
     * 1. 遍历左右两部分数组，把当前较小的元素放入数组中
     * 2. 遍历过程中执行四个判断：首先需要执行边界判断，否则可能出现越界报错情况
     * a. 如果左部分的指针越界大于mid了，则说明右部分还有排好序的元素需要保存到数组
     * b. 如果右部分的指针越界大于right了，则说明左部分还有排好序的元素需要保存到数组
     * c. 如果左指针指向的元素不比右指针大，则将左指针指向的元素保存到数组中
     * d. 如果右指针指向的元素比左指针小，则将右指针指向的元素保存到数组中
     *
     * @param data
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] data, int left, int mid, int right) {
        int i;

        // 借助临时数组用来保存数组
        // int[] temp = new int[data.length];
        // 临时数组在方法外开辟，不然每一次merge都要开数组
        temp = new int[data.length];

        // 先把所有元素复制到临时数组中
        for (i = left; i <= right; i++) {
            temp[i] = data[i];
        }

        // 左部分数组的第一个数字的指针和右部分数组的第一个数字的指针
        int point1 = left, point2 = mid + 1;

        // 执行数组合并
        for (i = left; i <= right; i++) {
            if (point1 > mid) {
                data[i] = temp[point2++];
            } else if (point2 > right) {
                data[i] = temp[point1++];
            } else if (temp[point1] <= temp[point2]) {
                data[i] = temp[point1++];
            } else {
                data[i] = temp[point2++];
            }
        }
    }
}
