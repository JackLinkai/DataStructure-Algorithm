package leetcode;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的中位数。
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000 解释：合并数组 = [1,2,3,4] ，
 * 中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * <p>
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 * <p>
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 * @author LinKai
 * @time 2021/02/13-11:17:00
 */
public class Solution4 {

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 6};
        int[] nums2 = {1, 2, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, point1 = 0, point2 = 0;
        double median;
        int len = n + m, num = len / 2;
        int[] nums = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (point1 == n) {
                nums[i] = nums2[point2++];
            } else if (point2 == m) {
                nums[i] = nums1[point1++];
            } else if (nums1[point1] <= nums2[point2]) {
                nums[i] = nums1[point1++];
            } else {
                nums[i] = nums2[point2++];
            }
        }
        if (len % 2 == 1) {
            median = nums[num] / 1.00000;
        } else {
            median = (nums[num - 1] + nums[num]) / 2.00000;
        }
        return median;
    }
}
