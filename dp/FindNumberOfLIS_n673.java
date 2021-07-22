package leetcode.dp;

import java.util.Arrays;

/**
 * @program: first
 * @description: 最长递增子序列的个数
 * @author: panhao
 * @date: 2021-07-22 09:06
 **/
public class FindNumberOfLIS_n673 {
    public static int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len==1) return 1;
        int[] count = new int[len];
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == max) res += count[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        System.out.println(findNumberOfLIS(nums));
    }
}
