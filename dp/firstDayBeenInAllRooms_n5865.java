package leetcode.dp;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-05 15:24
 **/
public class firstDayBeenInAllRooms_n5865 {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int len = nextVisit.length;
        int mod = (int) (1e9 + 7);
        // dp[i]表示离开第i个房间所需要的最少天数。
        long[] dp = new long[len+1];
        for (int i = 0; i < len; i++) {
            if (nextVisit[i] == i) {
                dp[i + 1] = (dp[i] + 2 + mod) % mod;
            } else {
                dp[i + 1] = (dp[i] * 2 - dp[nextVisit[i]] + 2 + mod) % mod;
            }
        }
        return (int) dp[len - 1];
    }
}
