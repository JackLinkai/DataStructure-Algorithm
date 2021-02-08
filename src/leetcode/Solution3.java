package leetcode;

import java.util.*;

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
        int nums = solution3.lengthOfLongestSubstring1("wobgrovw");
        System.out.println(nums);
    }

    /**
     * 思路：滑动窗口
     * 如果字符串为空，返回0，否则
     * 1. 创建一个窗口map，key为字符，value为下标
     * 2. 创建一个数max，记录最大值
     * 3. 把字符数组第一个字符添加到map中
     * 4. 依次遍历字符数组
     * 5. 如果遍历到的字符在map中，删掉map中第一个元素，直到该字符不存在map中
     * 6. 如果遍历到的字符不在map中，将其添加到map中
     * 7. 将目前最长字串的长度保存在max中
     * 心得总结：
     * 执行用时：12 ms, 在所有 Java 提交中击败了26.72%的用户
     * 内存消耗：9.1 MB, 在所有 Java 提交中击败了14.21%的用户
     * 代码可以说真的是很不行了，对于基本的api，也发现忘记了很多，从10点半有思路开始尝试到2点总算完成
     * 最主要是居然没有想到加一个max记录所出现的最长字串长度，这一点我要用心了
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        } else if (s != null) {
            char[] string = s.toCharArray();

            // 1. 创建一个窗口map，key为字符，value为下标
            Map<Character, Integer> map = new LinkedHashMap<>(len);
            // 2. 创建一个数max，记录最大值
            int max = 0;
            // 3. 把字符数组第一个字符添加到map中
            map.put(string[0], 0);
            // 4. 依次遍历字符数组
            for (int i = 1; i < len; i++) {
                // 5. 如果遍历到的字符在map中
                if (map.containsKey(string[i])) {
                    for (Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator(); it.hasNext() && map.containsKey(string[i]); ) {
                        Map.Entry<Character, Integer> item = it.next();
                        // 删掉map中第一个元素，直到该字符不存在map中
                        it.remove();
                    }
                }
                // 6. 如果遍历到的字符不在map中，将其添加到map中
                map.put(string[i], i);
                //7. 将目前最长字串的长度保存在max中
                max = map.size() > max ? map.size() : max;
            }
            return max;
        }
        return 0;
    }


    /**
     * 思路：滑动窗口
     * 1. 窗口occ用HashSet实现
     * 2.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        // ans统计最长字串
        int rk = -1, ans = 0;
        // 如果
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            // 当下一个字符在字符串中并且窗口中没有该字符
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(++rk));
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}