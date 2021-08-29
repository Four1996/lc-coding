package leetcode.dp;

import java.util.Arrays;

/**
 * @program: first
 * @description: 不同的子序列
 * @author: panhao
 * @date: 2021-08-29 14:11
 **/
public class distinctSubseqII_n940 {
    public int distinctSubseqII(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        int mod = (int) (1e9 + 7);
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < len; i++) {
            int x = chars[i] - 'a';
            dp[i + 1] = dp[i] * 2 % mod;
            if (last[x] >= 0) {
                dp[i + 1] -= dp[last[x]];
            }
            dp[i + 1] %= mod;
            last[x] = i;
        }
        dp[len]--;
        if (dp[len] < 0) {
            return dp[len] += mod;
        }
        return dp[len];
    }
}
