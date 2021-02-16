package main.algorithm.sort;

import java.util.Arrays;

/**
 * @author LinKai
 * @time 2021/02/15-22:38:00
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] data = {5, 6, 2, 8, 3, 9, 0, 5};
        sort(0, data.length - 1, data);
        System.out.println(Arrays.toString(data));
    }

    private static void sort(int low, int high, int[] data) {
        if (high<=low) {
            return;
        }
        int x = data[low], i = low, j = high;
        for (; j > i; j--) {
            if (data[j] <= x) {
                data[i] = data[j];

                for (i++; i < j; i++) {
                    if (x < data[i]) {
                        data[j] = data[i];
                        break;
                    }
                }
            }
        }
        data[i] = x;
        sort(low, i-1, data);
        sort(i+1, high, data);
    }
}
