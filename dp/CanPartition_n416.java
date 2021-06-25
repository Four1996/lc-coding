package leetcode.dp;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年06月14日 3:10 下午
 */
public class CanPartition_n416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        boolean[][] dp = new boolean[nums.length][(sum / 2) + 1];
        if (nums[0] <= (sum / 2)) dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
                if (dp[nums.length - 1][sum / 2]) break;
            }
        }
        return dp[nums.length - 1][sum / 2];
    }
}
