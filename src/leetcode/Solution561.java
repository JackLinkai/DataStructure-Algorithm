package leetcode;

/**
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从 1 到 n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 +2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 * <p>
 * 示例 2：
 * 输入：nums = [6,2,6,5,1,2]
 * 输出：9
 * 解释：最优的分法为 (2, 1), (2, 5), (6, 6).
 * min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
 * <p>
 * 提示：
 * 1 <= n <= 10^4
 * nums.length == 2 * n
 * -10^4 <= nums[i] <= 10^4
 *
 * @author LinKai
 * @time 2021/02/16-11:32:00
 */
public class Solution561 {

    /**
     * 思路1：先排序，再计算最优分法的最大总和
     * 因为若想要每一组的最小值的总和最大，
     * 则每一组的大小差距要达到最小，
     * 而天然排好序的数组则可以满足以上这一点。
     * 因为排序不需要稳定性，且数组长度过大，
     * 所以选择快速排序。
     * 执行用时： 16 ms , 在所有 Java 提交中击败了 12.92% 的用户
     * 内存消耗： 40.7 MB , 在所有 Java 提交中击败了 24.85% 的用户
     *
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        int n = nums.length, sum = 0;
        sort(nums, 0, n - 1);
        for (int i = 0; i < n; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }

    private static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int x = nums[low], i = low, j = high;
        for (; j > i; j--) {
            if (nums[j] <= x) {
                nums[i] = nums[j];
                for (i++; i < j; i++) {
                    if (nums[i] > x) {
                        nums[j] = nums[i];
                        break;
                    }
                }
            }
        }
        nums[i] = x;
        sort(nums, low, i - 1);
        sort(nums, i + 1, high);
    }
}
