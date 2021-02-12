package main.algorithm.sort;

/**
 * 希尔排序：优化版插入排序
 * 插入排序是从下标1开始排序的每次往前1位进行大小对比，
 * 而希尔排序是从下标为增量add的位置开始排序，每次往前add位进行大小对比。
 *
 * @author: LinKai
 * @time: 2021/2/4-13:02
 */

public class HillSort {

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 0, 1, 3, 2};
        int n = a.length;
        sort(a, n);
        for (int t = 0; t < n; t++) {
            System.out.print(a[t]);
        }
    }

    /**
     * 思路：
     * 1. 定义一个增量add=n/2，并按照增量分组，随后增量递减直至为1
     * 2. 从下标add开始，分出n-add组第一组最后的数为a[add]，第二组最后的数为a[add+1]……
     * 3. 同插入排序，向前遍历所在组内的前一个数i-add
     * 4. 如果a[i-add]比当前的数t大，则将a[i-add](a[j])往后移动，再比较a[i-add-add](a[j-add])……
     * 5. 否则就将t插入到a[j+add]
     *
     * @param a
     * @param n
     * @return
     */
    private static int[] sort(int[] a, int n) {
        // 临时变量t
        int t;
        // 1. 定义一个增量add=n/2，并按照增量分组，随后增量递减直至为1
        for (int add = n / 2; add >= 1; add /= 2) {
            // 2. 从下标add开始，分出n-add组第一组最后的数为a[add]，第二组最后的数为a[add+1]……
            for (int i = add; i < n; i++) {
                t = a[i];
                // 3. 同插入排序，向前遍历所在组内的前一个数i-add
                int j = i - add;
                // 4. 如果a[i-add]比当前的数t大，则将a[i-add](a[j])往后移动，再比较a[i-add-add](a[j-add])……
                // 从尾到头进行比较
                for (; j >= 0; j-=add) {
                    // 如果这个数大，就往后移，直到到达data正确的位置
                    if (a[j] > t) {
                        a[j + add] = a[j];
                    } else {
                        break;
                    }
                }
                // 5. 否则就将t插入到a[j+add]
                a[j + add] = t;
            }
        }
        return a;
    }
}