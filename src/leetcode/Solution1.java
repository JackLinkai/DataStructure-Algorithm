package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * 2 <= nums.length <= 10^3
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 只会存在一个有效答案
 *
 * @author: LinKai
 * @time: 2021/1/30-14:40
 */

public class Solution1 {
    public static void main(String[] args) throws IllegalAccessException {
        int[] result;
        int target = 0;
        int[] nums = {0, -7, -14, 2, 8, 11, 8, 0};
        result = twoSum_2(nums, target);
        for (int i = 0; i < 2; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 思路1：暴力求解
     * 枚举数组中所有的不同的两个下标的组合
     * 逐个检查他们的值是否等于target
     * 时间复杂度：O(N^2)，空间复杂度：O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_1(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 思路2：查找表法
     * 在遍历的同时，记录一些信息，以省去一层循环，“以空间换时间”
     * 需要记录已经遍历过的数值和它所对应的下标，可以借助查找表实现
     * 查找表有两个常用的实现：哈希表、平衡二叉搜索树（无须排序，选哈希表）
     * 1. 遍历数组
     * 2. 若当前的数值nums[i]所对应的数不在查找表中，保存其下标和值到查找表中
     * 3. 若若当前的数值nums[i]所对应的数在查找表中，找到，返回两数下标
     * 时间复杂度：O(N)，空间复杂度：O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_2(int[] nums, int target) {
        int len = nums.length;
        // 初始化一个hash表
        Map<Integer, Integer> hashMap = new HashMap<>(len - 1);
        // 先把第一个值保存在hash表中
        hashMap.put(nums[0], 0);
        // 遍历
        for (int i = 1; i < len; i++) {
            int other = target - nums[i];
            if (hashMap.containsKey(other)) {
                return new int[]{hashMap.get(other), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }

}
