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
     * 老板是连续X分钟保持冷静
     * 执行用时：616 ms, 在所有 Java 提交中击败了7.73%的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了14.83%的用户
     *
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max = 0, max_i = 0, count;
        for (int i = X - 1; i < customers.length; i++) {
            count = 0;
            for (int j = 0; j < X; j++) {
                if (grumpy[i - j] == 1) {
                    count += customers[i - j];
                }
            }
            if (count > max) {
                max_i = i;
                max = count;
            }
        }
        for (int k = 0; k < customers.length; k++) {
            if (grumpy[k] == 0) {
                max += customers[k];
            }
        }
        return max;
    }
}
