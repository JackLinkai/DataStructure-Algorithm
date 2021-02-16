package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，
 * 其中单个区间为 intervals[i] = [starti, endi]
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，
 * 该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 提示：
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 *
 * @author LinKai
 * @time 2021/02/16-13:19:00
 */
public class Solution56 {
    /**
     * 思路：
     * 1. 先对输入数组按照区间左边的值进行升序排列
     * 2. 初始化一个变量 outputs，用于存储合并之后区间结果的动态数组
     * 3. 遍历排序后的所有区间，针对每个区间做如下的处理：
     * 3.a. 如果当前处理的区间是第一个区间的话，那么直接将区间加入到 outputs
     * 3.b. 比较当前处理区间左边的值 (currLeft) 和 outputs 中最后一个区间右边的值 (outputsLastRight) ：
     * 3.b.I. 如果 outputsLastRight < currLeft，说明没有重叠，那么直接将当前处理的区间加入到 outputs
     * 3.b.II. 否则，说明有重叠，那么将 outputs 中最后一个区间的右边的值更新为：当前处理区间右边值和 outputsLastRight 的最大值
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // 1. 先对输入数组按照区间左边的值进行升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 表示按照第一列进行排序
                // 正数表示先o2再o1
                // 负数表示先o1再o2
                return o1[0]-o2[0];
            }
        });

        // 2. 初始化一个变量 outputs，用于存储合并之后区间结果的动态数组
        ArrayList<int[]> outputs = new ArrayList<>();

        // 3. 遍历排序后的所有区间，针对每个区间做如下的处理：
        // 3.a. 如果当前处理的区间是第一个区间的话，那么直接将区间加入到 outputs
        outputs.add(intervals[0]);
        int n = intervals.length;
        for (int i=1;i<n;i++){
            // 3.b. 比较当前处理区间左边的值 (currLeft) 和 outputs 中最后一个区间右边的值 (outputsLastRight) ：
            int currLeft = intervals[i][0];
            int[] outputsLast = outputs.get(outputs.size()-1);
            int outputsLastRight=outputsLast[1];
            // 3.b.I. 如果 outputsLastRight < currLeft，说明没有重叠，那么直接将当前处理的区间加入到 outputs
            if (outputsLastRight < currLeft){
                outputs.add(intervals[i]);
            }else{
                // 3.b.II. 否则，说明有重叠，那么将 outputs 中最后一个区间的右边的值更新为：当前处理区间右边值和 outputsLastRight 的最大值
                int currRight = intervals[i][1];
                outputsLast[1]=Math.max(currRight,outputsLastRight);
            }
        }
        return outputs.toArray(new int[outputs.size()][]);
    }
}
