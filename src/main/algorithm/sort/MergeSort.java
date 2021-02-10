package main.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author: LinKai
 * @time: 2021/2/10-10:11
 */

public class MergeSort {

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

    public static void merge(int[] data, int left, int mid, int right) {
        // 借助临时数组用来保存数组
        int[] temp = new int[data.length];

        // 左部分数组的第一个数字的指针
        int point1 = left;
        //右部分数组的第一个数字的指针
        int point2 = mid + 1;

        // 当前要保存到的临时数组的位置
        int loc = left;

        // 遍历左右两部分数组，将比较小的数依次排好顺序保存到临时数组中
        while (point1 <= mid && point2 <= right) {
            if (data[point1] < data[point2]) {
                temp[loc++] = data[point1++];
            } else {
                temp[loc++] = data[point2++];
            }
        }
        // 然后将左右两部分剩下的数字保存到临时数组中
        while (point1 <= mid) {
            temp[loc++] = data[point1++];
        }
        while (point2 <= right) {
            temp[loc++] = data[point2++];
        }

        // 最后将临时数组排好序的结果保存到原数组
        for (int i = left; i <= right; i++) {
            data[i] = temp[i];
        }
    }
}
