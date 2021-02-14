package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * 输入: [4,3,2,7,8,2,3,1]
 * 输出: [5,6]
 *
 * @author LinKai
 * @time 2021/02/13-09:38:00
 */
public class Solution488 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.printf(findDisappearedNumbers(nums).toString());
    }

    /**
     * 思路：
     * 因为数组的值的范围在1-n，
     * 所以数组中每个元素的值num减一都可以对应该数组的某一位置的下标值i（num-1=i），
     * 而没有被对应到的数组下标i则说明数组缺失了i+1这个数。
     * 我们可以把(num-1)%n作为下标，将nums[(num-1)%n]的值加上n，
     * 最后遍历数组，如果有nums[i]小于等于n，
     * 说明i+1就是缺失的数字
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int num : nums) {
            nums[(num - 1) % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
