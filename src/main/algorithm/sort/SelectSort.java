package main.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序：
 * 从未排序区间中找到最小（大）的元素，
 * 将其放到已排序区间的末尾
 *
 * @author: LinKai
 * @time: 2021/2/4-13:02
 */
public class SelectSort {

  public static void main(String[] args) {
    int[] data = {5, 6, 2, 8, 3, 9, 0, 5};
    sort(data);
    System.out.println(Arrays.toString(data));
  }

  /**
   * 思路：
   * 1. 首先数组分为排好序和未排好序两部分
   * 2. 找出当前未排序中最小的元素，与当前排好序的最后一个元素进行交换
   *
   * @param data
   */
  private static void sort(int[] data) {
    // 数组长度n，保存最小数的小标值min，中间变量temp
    // int temp;
    int n = data.length, min;

    // 进行n-1次排序，因为最后一个元素不用比较了
    for (int i = 0; i < n - 1; i++) {
      min = i;
      // 遍历未排序的部分
      for (int j = i + 1; j < n; j++) {
        // 使用min标记最小的元素的下标
        if (data[j] < data[min]) {
          min = j;
        }
      }
      if (min != i) {
        // 把未排序的最小的元素与排好序的最后一个元素交换
        /**
         * 原来需要借助临时变量完成data[i]和data[min]的交换
         * temp = data[i];
         * data[i] = data[min];
         * data[min] = temp;
         */
        //优化为加减法完成交换
        data[i] = data[i] + data[min];
        data[min] = data[i] - data[min];
        data[i] = data[i] - data[min];
      }
    }
  }
}
