package main.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author: LinKai
 * @time: 2021/2/4-13:02
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] data = {5, 6, 2, 8, 3, 9, 0, 5};
        sort(data);
        System.out.println(Arrays.toString(data));
    }

    /**
     * 冒泡排序：
     * 可以说是选择排序的优化
     * 每一次将相邻的两个元素进行对比，大的放在后面，小的放前面
     * 一次循环过后，最大的沉到最后面
     * n-1次循环之后完成排序
     * <p>
     * 优化：
     * 1. 数值交换的优化，使用加减法进行优化省去一个临时变量
     * 2. 当所有的数都在它该在的位置上时，即已经拍好顺序，则可以不用再遍历数组执行排序了，直接退出循环
     *
     * @param data
     */
    private static void sort(int[] data) {
        // 数组长度n，临时变量temp
        // int temp;
        int n = data.length;

        // 布尔标记，为true时说明数组已经排好序了
        boolean flag;

        // j<n-1:j是排序的次数，因为排到剩下一个就不用排列了，
        for (int j = 0; j < n - 1; j++) {
            // 先标记flag为true
            flag = true;

            // 每一个元素与下一个元素比较，大的放在后面，小的放前面，
            // 一次循环会把未排序中最大的元素放到最后，
            // 循环j次就有j个元素已经排好序
            // 于是0到n-j-2部分未排序，n-j-1到n-1排好序
            for (int i = 0; i < n - j - 1; i++) {
                // 判断条件为data[i] > data[i + 1]，则排序算法稳定
                // 判断条件为data[i] >= data[i + 1]，则排序算法不稳定
                if (data[i] > data[i + 1]) {
                    // 如果当前的元素比下一个元素大，交换两个元素
                    /**
                     * temp = data[i];
                     * data[i] = data[i + 1];
                     * data[i + 1] = temp;
                     * data[i]与data[i+1]的值交换可以优化，节约一个临时变量
                     */
                    data[i] = data[i] + data[i + 1];
                    data[i + 1] = data[i] - data[i + 1];
                    data[i] = data[i] - data[i + 1];

                    // 如果依旧有乱序的，将flag赋值为false
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
