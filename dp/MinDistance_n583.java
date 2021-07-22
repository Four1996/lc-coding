package leetcode.dp;

/**
 * @program: first
 * @description: 两个字符串的删除操作
 * @author: panhao
 * @date: 2021-07-22 19:34
 **/
public class MinDistance_n583 {
    public static int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return l1 + l2 - dp[l1][l2] * 2;
    }

    public static void main(String[] args) {
        String word1="sea";
        String word2="eat";
        System.out.println(minDistance(word1,word2));
    }
}
