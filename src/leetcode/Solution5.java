package leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * @author LinKai
 * @time 2021/02/14-16:23:00
 */
public class Solution5 {

    public static void main(String[] args) {

    }

    /**
     * 思路1：动态规划
     * 对于一个子串而言，如果它是回文串，并且长度大于 2，
     * 那么将它首尾的两个字母去除之后，它仍然是个回文串。
     * 例如对于字符串“ababa”，
     * 如果我们已经知道“bab” 是回文串，那么 “ababa” 一定是回文串，
     * 这是因为它的首尾两个字母都是“a”。
     * 根据这样的思路，我们就可以用动态规划的方法解决本题。
     *
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        String string = "";
        int n = s.length(),max=0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (str[i] == str[j]) {

                }
            }
        }
        return string;
    }
}