package leetcode.dp;

import java.util.Arrays;

/**
 * @program: first
 * @description: K个逆序对数组
 * @author: panhao
 * @date: 2021-11-11 19:08
 **/
public class kInversePairs_n629 {
    public int kInversePairs(int n, int k) {
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[n + 1][k + 1];
        int[][] pre = new int[n + 1][k + 1];
        dp[1][0] = 1;
        Arrays.fill(pre[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j < i) {
                    dp[i][j] = pre[i - 1][j];
                } else {
                    dp[i][j] = (pre[i - 1][j] - pre[i - 1][j - (i - 1) - 1] + mod) % mod;
                }
                if (j == 0) {
                    pre[i][j] = dp[i][j];
                } else {
                    pre[i][j] = (pre[i][j - 1] + dp[i][j]) % mod;
                }
            }
        }
        return dp[n][k];
    }
}
