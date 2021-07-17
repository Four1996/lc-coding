package leetcode.dp;

/**
 * @program: first
 * @description: 等差数列划分
 * @author: panhao
 * @date: 2021-07-17 10:37
 **/
public class NumberOfArithmeticSlices_n413_2 {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }
}
