package leetcode;

import java.util.*;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-07 23:15
 **/
public class MinSpaceWastedKResizing_n5828 {
    int INF = 0x3f3f3f3f;
    int n, sum;
    public int minSpaceWastedKResizing(int[] nums, int k) {
        n = nums.length;
        sum = 0;
        int[][] premax = new int[n][n];
        for (int i = 0; i < n; i++){
            int m = 0;
            for(int j = i; j < n; j++){
                m = Math.max(m, nums[j]);
                premax[i][j] = m * (j + 1 - i);
            }
            sum += nums[i];
        }

        int[][] dp = new int[n][k+2];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], INF);

        for (int i = 0; i < n; i++)
            for (int j = 1; j <= k + 1; j++)
                for (int l = 0; l <= i; l++)
                    dp[i][j] = Math.min(dp[i][j], (l == 0 ? 0 : dp[l-1][j-1]) + premax[l][i]);
        return dp[n-1][k+1] - sum;
    }

    public static void main(String[] args) {
        // int[] nums={10,20,15,30,20};
        // int[] nums={10,20,30};
        // int[] nums={10,20};
        int[] nums={13,46,42,45,35};
        System.out.println(new MinSpaceWastedKResizing_n5828().minSpaceWastedKResizing(nums,4));
    }
}
