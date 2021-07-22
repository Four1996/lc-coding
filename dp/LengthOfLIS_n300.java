package leetcode.dp;

import java.util.Arrays;

/**
 * @program: first
 * @description: 最长递增子序列
 * @author: panhao
 * @date: 2021-07-21 15:37
 **/
public class LengthOfLIS_n300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
