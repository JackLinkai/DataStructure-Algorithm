package leetcode;

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
    /**
     * 思路：滑动窗口
     * 如果字符串为空，返回0，否则
     * 1. 创建一个窗口map，key为字符，value为下标
     * 2. 把字符数组第一个字符添加到map中
     * 3. 依次遍历字符数组，如果遍历到的字符在map中，删掉map中第一个元素，直到该字符不存在map中
     * 4. 如果遍历到的字符不在map中，将其添加到map中
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s!=null){

        }
        return 0;
    }
}
