package main.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * 小偷去某商店盗窃，背有一个背包，容量是50kg，
 * 现在有以下物品（物品不能切分,且只有一个），请问小偷应该怎么拿才能得到最大的价值？
 * |       | 重量 | 价值  |
 * | ----- | ---- | ----- |
 * | 物品1 | 10kg | 60元  |
 * | 物品2 | 20kg | 100元 |
 * | 物品3 | 40kg | 120元 |
 *
 * @author LinKai
 * @time 2021/03/07-16:08:00
 */
public class Backpack {

    public static void main(String[] args) {
        // 物品对应的重量（10kg）和价值（元）
        int[] w = {1, 2, 4}, v = {60, 100, 120};
        // weight是背包容量（10kg）,n是物品数量
        int weight = 5, n = 3;
        // 一般动态规划都会需要这样一个dp，这就是我们画的那个表
        int[][] dp = new int[n + 1][weight + 1];
        // 每次加入的物品
        for (int i = 1; i <= n; i++) {
            // 分割的背包
            for (int j = 1; j <= weight; j++) {
                // 如果说背包可以装
                if (w[i - 1] <= j) {
                    // v[i-1]:当前物品的价值，dp[i-1][j-w[i-1]]:加入当前物品之前还可以存放当前物品时的背包价值
                    // 加入物品和未加入物品进行比较
                    dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println("获得的最大价值：" + dp[n][weight]);
        System.out.println("获得最大价值的物品");
        for (int i = n; i > 0; i--) {
            if (dp[i][weight] == dp[i - 1][weight]) {
                // 说明i物品加不加都一样
            } else {
                // 否则就说明该物品可以装
                System.out.println("物品" + i);
                weight -= w[i - 1];
            }
        }
    }

}
