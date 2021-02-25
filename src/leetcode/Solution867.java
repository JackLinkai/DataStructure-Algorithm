package leetcode;

/**
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 10^5
 * -10^9 <= matrix[i][j] <= 10^9
 *
 * @author LinKai
 * @time 2021/02/25-23:05:00
 */
public class Solution867 {

    /**
     * 思路：借助一个数组，把行变成列列变成行
     * 有的时候算法题就是这么简单，不用想太复杂
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了13.07%的用户
     * @param matrix
     * @return
     */
    public int[][] transpose(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int[][] tran=new int[m][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                tran[j][i]=matrix[i][j];
            }
        }
        return tran;
    }
}
