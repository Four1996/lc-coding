package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 最佳观光组合
 * @author: panhao
 * @date: 2021-07-09 21:08
 **/
public class MaxScoreSightseeingPair_n1014 {
    public static int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int[] v = new int[len - 1];
        v[len - 2] = values[len - 1] - len + 1;
        for (int i = len - 3; i >= 0; i--) {
            v[i] = Math.max(values[i + 1] - i - 1, v[i + 1]);
        }
        int[] dp = new int[len - 1];
        int ans = 0;
        for (int i = 0; i < len - 1; i++) {
            dp[i] = values[i] + i + v[i];
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(nums));
    }
}
