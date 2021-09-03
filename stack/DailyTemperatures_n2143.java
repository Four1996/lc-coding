package leetcode.stack;

/**
 * @program: first
 * @description: 每日温度
 * @author: panhao
 * @date: 2021-09-03 20:01
 **/
public class DailyTemperatures_n2143 {
    public int[] dailyTemperatures(int[] temp) {
        int len = temp.length;
        int[] dp = new int[len];
        dp[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            int count = 1;
            int idx = i;
            while (idx + 1 < len && temp[i] >= temp[idx + 1]) {
                if (dp[idx + 1] == 0) {
                    count = 0;
                    break;
                } else {
                    count += dp[idx + 1];
                    idx += dp[idx + 1];
                }
            }
            dp[i] = count;
        }
        return dp;
    }
}
