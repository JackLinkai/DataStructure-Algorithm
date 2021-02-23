package leetcode;

/**
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。
 * 每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * <p>
 * 示例：
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：书店老板在最后 3 分钟保持冷静。感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * <p>
 * 提示：
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 *
 * @author LinKai
 * @time 2021/02/23-19:12:00
 */
public class Solution1052 {

    /**
     * 思路：滑动窗口
     * 老板是连续X分钟保持冷静，我们可以借助数组做一个有X长度的窗口
     * 1. 从X-1开始遍历，计算当前窗口挽回的用户数
     * 2. 使用变量max获得最大的挽回用户数
     * 3. 再算出原来满意的用户，相加就是最大的用户满意数
     * 执行用时：207 ms, 在所有 Java 提交中击败了12.01%的用户
     * 内存消耗：40.8 MB, 在所有 Java 提交中击败了73.97%的用户
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max = 0, count;
        for (int i = X - 1; i < customers.length; i++) {
            count = 0;
            for (int j = 0; j < X; j++) {
                count += customers[i - j] * grumpy[i - j];
            }
            max = Math.max(count, max);
        }
        for (int k = 0; k < customers.length; k++) {
            if (grumpy[k] == 0) {
                max += customers[k];
            }
        }
        return max;
    }
}
