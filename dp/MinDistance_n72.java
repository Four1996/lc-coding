package leetcode.dp;

/**
 * @program: first
 * @description: 编辑距离
 * @author: panhao
 * @date: 2021-07-23 14:49
 **/
public class MinDistance_n72 {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        // dp[i][j]表示word1的前i个字符变成word2的前j个字符所需要的最少步骤。
        int[][] dp = new int[l1 + 1][l2 + 1];
        // 初始状态1，空串变成空串需要0步。
        dp[0][0] = 0;
        // 初始状态2，空串变成前j个word2字符显然需要j步：即执行添加j次的操作。
        for (int j = 1; j <= l2; j++) {
            dp[0][j] = j;
        }
        // 初始状态3，前i个word1的字符变成空串需要i步：即执行i次删除操作即可。
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = i;
        }
        // 状态4，前i个word1字符转换成前j个word2字符需要多少步？
        // 移动到当前i，j下标时，判断word1[i]与word2[j]字符的关系：
        // 如果相等，说明当前步骤不需要执行任何操作，所以此时直接取i-1，j-1状态时的结果即可。
        // 如果不相等，说明需要执行增删改中的一个步骤，以让前i个字符和前j个字符相同，分以下三种情况：
        // 1、dp[i-1][j]:word1增加一个字符。
        // 2、dp[i][j-1]:word2增加一个字符。
        // 3、dp[i-1][j-1]:修改word1的字符。
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        // 返回word1前l1长度字符转换为word2前l2长度字符需要的最少步骤。
        return dp[l1][l2];
    }
}
