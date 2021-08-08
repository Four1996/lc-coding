package leetcode.array;

/**
 * @program: first
 * @description: 暴力dp超时
 * @author: panhao
 * @date: 2021-08-08 11:28
 **/
public class LongestObstacleCourseAtEachPosition_n5841 {
    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int len = obstacles.length;
        int[] ans = new int[len];
        int[][] dp = new int[len][2];
        dp[0][0] = obstacles[0];
        dp[0][1] = 1;
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i][1] = 1;
            dp[i][0] = obstacles[i];
            for (int j = 0; j < i; j++) {
                if (obstacles[i] >= dp[j][0]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                }
            }
            ans[i] = dp[i][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={5,3,4,4,4,2,1,1,4,1};
        System.out.println(longestObstacleCourseAtEachPosition(nums));
    }
}
