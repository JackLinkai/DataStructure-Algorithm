package leetcode;

/**
 * 情侣牵手：
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。
 * 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。
 * 一次交换可选择任意两人，让他们站起来交换座位。
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，
 * 第一对是 (0, 1)，第二对是 (2, 3)，
 * 以此类推，最后一对是 (2N-2, 2N-1)。
 * 这些情侣的初始座位 row[i] 是由最初始坐在第 i 个座位上的人决定的。
 * <p>
 * 示例 1:
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * <p>
 * 示例 2:
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 * <p>
 * 说明:
 * len(row) 是偶数且数值在 [4, 60]范围内。
 * 可以保证row 是序列 0...len(row)-1 的一个全排列。
 *
 * @author LinKai
 * @time 2021/02/14-16:34:00
 */
public class Solution765 {

    public static void main(String[] args) {
        int[] row = {3, 2, 0, 1};
        System.out.println(minSwapsCouples(row));
    }

    /**
     * 思路1：
     * 人生第一次力扣的题做一遍就过，可能恩爱狗在情人节做情人节专属力扣题有buffer加成吧。
     * 最近刚好在研究排序算法，刚好这道题像极了选择排序。
     * 分析了一下场景，需要求最少的交换次数，
     * 但是情侣都是一一配对的，除非里面夹着单身狗（这样的话可能就不能按照逐个方法解决问题）
     * 所以从第一对情侣开始检查，检查到不对劲的就开始交换，
     * 换好之后再看下一对，直到换完，程序结束，
     * 时间复杂度O(n^2)。
     * 思路：
     * 1.从第一个人开始往后检查，之后每次隔一个人进行检查
     * 2. 如果说本次检查到的人的下一个人不是ta的对象，就找到ta对象把位置换过来并且交换次数加一
     * <p>
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 27.22% 的用户
     * 内存消耗： 35.9 MB , 在所有 Java 提交中击败了 53.48% 的用户
     *
     * @param row
     * @return
     */
    public static int minSwapsCouples(int[] row) {
        // 数组row长度len
        int len = row.length;
        // 最少交换次数计数器
        int count = 0;
        // 1. 从第一个人开始往后检查，之后每次隔一个人进行检查
        for (int i = 0; i < len; i += 2) {
            // 2. 如果说本次检查到的人的下一个人不是ta的对象，就找到ta对象把位置换过来并且交换次数加一
            // 如果当前的人是偶数
            if (row[i] % 2 == 0) {
                // 坐在ta下一个位置的人却不是ta的值加一，那么就不是ta对象
                if (row[i + 1] != row[i] + 1) {
                    // 便从ta下下个位置开始找ta对象
                    for (int j = i + 2; j < len; j++) {
                        // 找到了就换回来
                        if (row[j] == row[i] + 1) {
                            row[j] = row[i + 1];
                            row[i + 1] = row[i] + 1;
                            count++;
                        }
                    }
                }
            } else {
                // 这边同理
                if (row[i + 1] != row[i] - 1) {
                    for (int j = i + 2; j < len; j++) {
                        if (row[j] == row[i] - 1) {
                            row[j] = row[i + 1];
                            row[i + 1] = row[i] - 1;
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
