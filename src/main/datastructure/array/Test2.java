package main.datastructure.array;

/**
 * 找出数组中重复的数字：
 * 在一个长度为n的数组里的所有数字都在0~n-1范围内。
 * 有某些数字重复但是不知道哪几个数字重复了，重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例如：
 * 如果输入长度为7的数组{2，3，1，0，2，5，3}，
 * 那么对应的输出的重复数字2或者3.
 *
 * @author: LinKai
 * @time: 2021/1/5-16:15
 */

public class Test2 {

    /**
     * 题解：
     * 所有数字都在0~n-1范围内，那么数组重排之后，
     * 有的位置可能存在多个数字，有的位置则没有数字。
     * 让我们重排这个数组，从头到尾一次扫描这个数组的每个数字。
     * 当扫描到下标为i的数字时，首先比较这个数字m是不是等于i，
     * 是则继续扫描下一个数字，
     * 不是则与位置m的数字进行比较，
     * 相同，找到一个重复数字，
     * 不同，交换，重新扫描这个个数字。
     *
     * 时间复杂度O(n),空间复杂度O(1)
     *
     * @param nums
     * @param n
     * @return
     */
    public static int duplicate(int[] nums, int n) {
        // 如果数组为空或者数组长度小于0则没有重复数字
        if (nums == null || n <= 0) {
            return -1;
        }

        int i;

        // 如果不符合题意，返回n
        for (i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] > n - 1) {
                return n;
            }
        }

        int t;

        for (i = 0;i < n;++i) {
            // 数字m不等于i，执行操作直到等于i
            while (i!=nums[i]){
                // 相同
                if (nums[i] == nums[nums[i]]) {
                    // 找到一个重复数字
                    return nums[i];
                }
                t = nums[i];
                nums[i] = nums[t];
                nums[t] = t;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, 1, 0, 2, 5, 3};
        int n = 7;
        System.out.println(duplicate(nums, n));
    }
}
