package leetcode.dp;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-12 09:51
 **/
public class LongestPalindromeSubseq_n516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        // dp[i][j]代表字符串s在[i,...,j]范围内的最大回文子串。
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
