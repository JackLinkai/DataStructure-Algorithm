package leetcode;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 * <p>
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * <p>
 * 进阶：
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * @author LinKai
 * @time 2021/02/16-19:21:00
 */
public class Solution75 {

    /**
     * 对比了几个排序算法，
     * 本题不要求稳定性
     * 因此考虑使用快排
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.7 MB, 在所有 Java 提交中击败了93.43%的用户
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
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
