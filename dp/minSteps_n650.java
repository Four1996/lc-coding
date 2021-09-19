package leetcode.dp;

/**
 * @program: first
 * @description: 只有两个键的键盘
 * @author: panhao
 * @date: 2021-09-19 09:45
 **/
public class minSteps_n650 {
    public static int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minSteps(9));
    }
}
