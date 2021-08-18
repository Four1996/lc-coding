package leetcode.dp;

/**
 * @program: first
 * @description: 学生出勤记录II
 * @author: panhao
 * @date: 2021-08-18 09:51
 **/
public class CheckRecord_n552 {
    public static int checkRecord(int n) {
        int mod = (int) (1e9 + 7);
        long[] dp = new long[8];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 0;
        dp[5] = 0;
        dp[6] = 0;
        dp[7] = 0;
        for (int i = 1; i < n; i++) {
            long temp1 = (dp[2] + dp[3] + dp[4]) % mod;
            long temp2 = dp[3] % mod;
            long temp3 = (dp[2] + dp[3] + dp[4]) % mod;
            long temp4 = dp[2] % mod;
            long temp5 = (dp[1] + dp[6]) % mod;
            long temp6 = (dp[1] + dp[5] + dp[6] + dp[7]) % mod;
            long temp7 = dp[5] % mod;
            dp[1] = temp1;
            dp[2] = temp2;
            dp[3] = temp3;
            dp[4] = temp4;
            dp[5] = temp5;
            dp[6] = temp6;
            dp[7] = temp7;
        }
        return (int) ((dp[1] + dp[2] + dp[3] + dp[4] + dp[5] + dp[6] + dp[7]) % mod);
    }

    public static void main(String[] args) {
        System.out.println(checkRecord(2));
    }
}
