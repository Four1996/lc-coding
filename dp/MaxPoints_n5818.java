package leetcode.dp;

import java.util.TreeSet;

/**
 * @program: first
 * @description: 拆项dp
 * @author: panhao
 * @date: 2021-07-18 10:48
 **/
public class MaxPoints_n5818 {
    public static long maxPoints(int[][] points) {
        int row = points.length, col = points[0].length;
        long[] dp = new long[col];
        for (int i = 0; i < col; i++) {
            dp[i] = points[0][i];
        }
        for (int i = 1; i < row; i++) {
            long[] cur = new long[col];
            long maxL = dp[0];
            cur[0] = maxL;
            for (int j = 1; j < col; j++) {
                maxL = Math.max(maxL - 1, dp[j]);
                cur[j] = maxL;
            }
            long maxR = dp[col - 1];
            cur[col - 1] = Math.max(cur[col - 1], maxR);
            for (int j = col - 2; j >= 0; j--) {
                maxR = Math.max(maxR - 1, cur[j]);
                cur[j] = maxR;
            }
            for (int j = 0; j < col; j++) {
                dp[j] = points[i][j] + cur[j];
            }
        }
        long res = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {4, 3, 2, 1},
                {1, 4, 3, 0},
                {0, 0, 1, 5},
                {1, 5, 3, 4},
                {0, 3, 3, 4}
        };
        System.out.println(maxPoints(nums));
    }
}
