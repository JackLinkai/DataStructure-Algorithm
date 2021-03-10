package main.datastructure.array;

/**
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下的顺序排序。
 * 请完成一个函数，
 * 输入这样的一个二维数组和一个整数，
 * 判断数组中是否有该整数。
 * <p>
 * 例如：在下面的二维数组找8
 * 1   2   7   9
 * 2   4   9   12
 * 4   8   10  13
 * 6   9   11  15
 *
 * @author: LinKai
 * @time: 2021/1/5-21:23
 */

public class Test3 {

    /**
     * 我们如果考虑在随机一个位置开始找数字8，则很复杂；
     * 如果从四个点入手开始找，从左上角和右下角开始，则我们无法利用范围剔除行和列；
     * 我们从左下角或者右上角开始，比如说从左下角6开始：
     * 6往右是9比8大，按照规律应该得往上找才可以找到8；上面是4，4比8小，则不能再网上找而是往右找，因此找到8。
     *
     * @param nums
     * @param n
     * @return
     */
    public static boolean find(int[][] nums, int n) {
        int x = nums[0].length;
        int y = nums.length;
        int i;
        int j = 0;

        // 如果数组不为空
        if (nums != null && x > 0 && y > 0) {
            // 从左下角开始
            for (i = y - 1; i >= 0; i--) {
                // 往右开始遍历
                while (j < x) {
                    // 相等则找到，返回true
                    if (n == nums[i][j]) {
                        return true;
                    } else if (n < nums[i][j]) {
                        // 如果n的值小，则没有必要继续往右找，直接退出往上开始遍历
                        break;
                    }
                    j++;
                }
            }
        }
        return false;
    }

    /**
     * 试试从右上角开始
     *
     * @param nums
     * @param n
     * @return
     */
    public static boolean find1(int[][] nums, int n) {
        int x = nums[0].length;
        int y = nums.length;
        int i;
        int j = x - 1;
        // 如果数组不为空
        if (nums != null && x > 0 && y > 0) {
            // 从右上角开始
            for (i = 0; i < y; i++) {
                // 往左开始遍历
                while (j >= 0) {
                    // 相等则找到，返回true
                    if (n == nums[i][j]) {
                        return true;
                    } else if (n > nums[i][j]) {
                        // 如果n的值大，则没有必要继续往左找，直接退出往下开始遍历
                        break;
                    }
                    j--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 7, 9},
                {2, 4, 9, 12},
                {4, 8, 10, 13},
                {6, 9, 11, 15}
        };
        System.out.println(find1(nums, 8));
    }
}
