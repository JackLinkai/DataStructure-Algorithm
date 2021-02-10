package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @author: LinKai
 * @time: 2021/1/31-17:41
 */

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int nums = solution3.lengthOfLongestSubstring("wobgrovw");
        System.out.println(nums);
    }

    /**
     * 思路：滑动窗口
     * 如果数组为空，返回0
     * 如果数组的长度小于2，返回数组长度。
     * 1. 用HashSet实现保存字符的滑动窗口win；
     * 2. 准备一个变量max统计出现的最长子串长度；
     * 3. 准备两个变量，一个是窗口的左端left，一个是窗口的右端right；
     * 4. 一开始窗口先存储数组的第一个元素；
     * 5. 如果窗口右端的下一个字符不在窗口中，将该字符放入窗口，右端指针指向该字符;
     * 6. 如果窗口右端的下一个字符在窗口中，将左端指针往后移动一位，直到右端的下一个字符不在窗口中；
     * 7. 每次右指针停止向右移动的时候，先将max与窗口的长度比较，大的保存在max中；
     * 心得总结：
     * 执行用时：9 ms, 在所有 Java 提交中击败了41.52%的用户
     * 内存消耗：39.2 MB, 在所有 Java 提交中击败了8.52%的用户
     * 代码可以说真的是很不行了，对于基本的api，也发现忘记了很多，从10点半有思路开始尝试到2点总算完成
     * 很愚蠢的是自己一开始使用LinkedHashMap以便保证窗口内的元素按照在字符串中的顺序继续排好序，根本就多此一举，窗口只是用来检查下一个元素存不存在
     * 最主要是居然没有想到加一个max记录所出现的最长字串长度，这一点我要用心了
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 如果数组为空，返回0
        if (s == null) {
            return 0;
        }

        // 数组长度
        int n = s.length();

        // 如果数组长度小于2，直接返回数组长度即可
        if (n > 1) {
            // 滑动窗口win
            Set<Character> win = new HashSet<>(n);

            // 存储最长子串长度max、窗口左端left，右端right
            int max = 1, left = 0, right = 0;

            // 保存s的第一个字符
            win.add(s.charAt(right));

            // 如果窗口右端的下一个字符在窗口中，将左端指针往后移动一位，直到右端的下一个字符不在窗口中；
            for (; left < n; left++) {

                // 如果窗口右端的下一个字符没有越界并且不在窗口中，将该字符放入窗口，右端指针指向该字符
                while (right + 1 < n && !win.contains(s.charAt(right + 1))) {
                    // 注意，先把right的指针向右移动，然后添加该字符
                    win.add(s.charAt(++right));
                }
                // 每次右指针停止向右移动的时候，先将max与窗口的长度比较，大的保存在max中
                max = max > win.size() ? max : win.size();

                // 将左端指针往后移动一位
                if (left != 0) {
                    win.remove(s.charAt(left - 1));
                }
            }
            return max;
        }
        return n;
    }
}