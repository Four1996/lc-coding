package leetcode.dp;

import java.util.Arrays;

/**
 * @program: first
 * @description: 零钱兑换
 * @author: panhao
 * @date: 2021-07-23 16:29
 **/
public class CoinChange_n322 {
    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][0] = 0;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] < 0) dp[i][j] = dp[i - 1][j];
                else {
                    if (dp[i][j - coins[i - 1]] == -1) dp[i][j] = -1;
                    else {
                        dp[i][j] = dp[i][j - coins[i - 1]] + 1;
                    }
                }
            }
        }
        return dp[len][amount];
    }

    public static void main(String[] args) {
        int[] coins = {2,5,10,1};
        System.out.println(coinChange(coins, 27));
    }
}
