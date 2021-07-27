package leetcode.dp;



/**
 * @author panhao 背包
 * @date 2021年06月14日 3:10 下午
 */
public class CanPartition_n416 {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int len = nums.length;
        if (sum % 2 != 0) return false;
        boolean[][] dp = new boolean[len + 1][sum / 2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
                if (dp[i][sum / 2]) return true;
            }
        }
        return dp[len - 1][sum / 2];
    }

    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        System.out.println(canPartition(nums));
    }

}
