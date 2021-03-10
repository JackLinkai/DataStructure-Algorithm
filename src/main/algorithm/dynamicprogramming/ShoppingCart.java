package main.algorithm.dynamicprogramming;

/**
 * 双十一马上就要来了，小C心目中的女神在购物车加了N个东西，
 * 突然她中了一个奖可以清空购物车5000元的东西（不能找零），
 * 每个东西只能买一件，
 * 那么她应该如何选择物品使之中奖的额度能最大利用呢？
 * 如果存在多种最优组合你只需要给出一种即可（要求还要输出选择商品的策略）
 *
 * @author LinKai
 * @time 2021/03/09-10:52:00
 */
public class ShoppingCart {
    public static void main(String[] args) {
        int[] cart = {500, 1200, 1500, 2400, 3200};
        // n是商品总数,m是清空购物车的额度
        int n = 5, m = 5000;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (cart[i - 1] <= j) {
                    dp[i][j] = Math.max(cart[i - 1] + dp[i - 1][j - cart[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][m]);
        System.out.println("具体的物品：");
        for (int i = n; i > 0; i--) {
            if (dp[i][m] == dp[i - 1][m]) {

            } else {
                System.out.println("商品" + i + ":" + cart[i - 1]);
                m = m - cart[i - 1];
            }
        }
    }
}
