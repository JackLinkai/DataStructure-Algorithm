package main.algorithm.sort;

/**
 * 插入排序：可以理解为打扑克时拿牌的过程
 *
 * @author: LinKai
 * @time: 2021/1/15-16:35
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {9, 8, 7, 0, 1, 3, 2};
        int n = a.length;
        sort(a, n);
        for (int t = 0; t < n; t++) {
            System.out.print(a[t]);
        }
    }

    /**
     * 思路：插入排序
     * 1. 从数组的第二个元素a[1]开始往后遍历，数组分为两部分，前部分排好序，后部分需要排序
     * 2. 遍历到的当前数字data与排好序的部分的元素a[j]进行比较，注意从尾到头开始对比
     * 3. 如果data比较小，则a[j]往后移动一位，否则退出循环
     * 4. 最后，把data放到前部分的空位置a[j+1]
     * 时间复杂度为：O(n^2)，最小的时间复杂度为O(n)（原数组已经排好序的情况下，程序直接就走break）
     *
     * @param a
     * @param n
     * @return
     */
    private static int[] sort(int[] a, int n) {
        // 临时变量t
        int t;
        // 两层循环
        // i从1开始是因为第一个不用排序，我们把数组从i分开，0-i部分已经排好序
        for (int i = 1; i < n; i++) {
            t = a[i];
            int j = i - 1;
            // 从尾到头进行比较
            for (; j >= 0; j--) {
                // 如果这个数大，就往后移，直到到达data正确的位置
                if (a[j] > t) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = t;
        }
        return a;
    }
}
