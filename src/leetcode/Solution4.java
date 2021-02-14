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

  /**
   * 思路：
   * 刚好最近在做有关排序算法的练习，这道题因为两个数组都是排好序了，要求出他们的中位数，
   * 刚好可以借用递归排序的思路，把两个排好序的数组合并成一个排好序的数组nums，
   * 如果nums的长度是单数，中位数就是最中间的那个数，
   * 如果nums的长度是双数，中位数就是最中间的两个数的平均数
   * 所以，只需要合并数组到要计算的那个数或者那两个数就可以了：
   * 1. 创建一个长度为两个数组长度和的一半加一的数组nums
   * 2. 逐个遍历这两个数组，把小的数保存到数组nums，直到保存完，注意需要有下面四个判断，并且需要对索引越界进行判断：
   * a. 判断nums1是不是遍历完了，是的话把当前遍历到的nums2的数组保存到nums数组中，继续遍历nums2的下一个
   * b. 判断nums2是不是遍历完了，是的话把当前遍历到的nums1的数组保存到nyms数组中，继续遍历nums1的下一个
   * c. 如果nums1当前的数不比nums2当前的数大，就把nums1当前的数保存到nums中，继续遍历nums1的下一个
   * d. 否则就把nums2当前的数保存到nums中，继续遍历nums2的下一个
   * 3. 最后根据数组长度单双数计算出中位数，记得处理为double类型
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
   * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 65.91% 的用户
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, point1 = 0, point2 = 0;
        double median;
        int len = n + m, num = len / 2;
        // 1. 创建一个长度为两个数组长度和的一半加一的数组nums
        int[] nums = new int[num + 1];
        // 2. 逐个遍历这两个数组，把小的数保存到数组nums，直到保存完，注意需要有下面四个判断，并且需要对索引越界进行判断：
        for (int i = 0; i <= num; i++) {
            if (point1 == n) {
                // a. 判断nums1是不是遍历完了，是的话把当前遍历到的nums2的数组保存到nums数组中，继续遍历nums2的下一个
                nums[i] = nums2[point2++];
            } else if (point2 == m) {
                // b. 判断nums2是不是遍历完了，是的话把当前遍历到的nums1的数组保存到nyms数组中，继续遍历nums1的下一个
                nums[i] = nums1[point1++];
            } else if (nums1[point1] <= nums2[point2]) {
                // c. 如果nums1当前的数不比nums2当前的数大，就把nums1当前的数保存到nums中，继续遍历nums1的下一个
                nums[i] = nums1[point1++];
            } else {
                // d. 否则就把nums2当前的数保存到nums中，继续遍历nums2的下一个
                nums[i] = nums2[point2++];
            }
        }
        // 3. 最后根据数组长度单双数计算出中位数，记得处理为double类型
        if (len % 2 == 1) {
            median = nums[num] / 1.00000;
        } else {
            median = (nums[num - 1] + nums[num]) / 2.00000;
        }
        return median;
    }
}
