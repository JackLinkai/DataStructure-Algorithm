package main.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序：
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
   *
   * @param data
   */
  private static void sort(int[] data) {
    // 数组长度n，临时变量temp
    int n = data.length, temp;

    // j<n-1:j是排序的次数，因为排到剩下一个就不用排列了，
    for (int j = 0; j < n - 1; j++) {
      // 每一个元素与下一个元素比较，大的放在后面，小的放前面，
      // 一次循环会把未排序中最大的元素放到最后，
      // 于是0到n-j-2部分未排序，n-j-1到n-1排好序
      for (int i = 0; i < n - j - 1; i++) {
        if (data[i] > data[i + 1]) {
          // 如果当前的元素比下一个元素大，交换两个元素
          temp = data[i];
          data[i] = data[i + 1];
          data[i + 1] = temp;
        }
      }
    }
  }
}