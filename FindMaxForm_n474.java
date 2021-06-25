package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author panhao
 * @date 2021年06月06日 6:10 下午
 * 定义状态：尝试题目问啥，就把啥定义成状态。dp[i][j][k] 表示输入字符串在子区间 [0, i] 能够使用 j 个 0 和 k 个 1 的字符串的最大数量。
 * 状态转移方程：
 *
 * dp[i][j][k]= \begin{cases} dp[i - 1][j][k], & 不选择当前考虑的字符串，至少是这个数值\\ dp[i - 1][j - 当前字符串使用 \;0\; 的个数][k - 当前字符串使用 \;1\; 的个数] + 1 & 选择当前考虑的字符串 \end{cases}
 * dp[i][j][k]={
 * dp[i−1][j][k],
 * dp[i−1][j−当前字符串使用0的个数][k−当前字符串使用1的个数]+1
 * ​
 *
 * 不选择当前考虑的字符串，至少是这个数值
 * 选择当前考虑的字符串
 * ​
 *
 *
 * 初始化：为了避免分类讨论，通常多设置一行。这里可以认为，第 00 个字符串是空串。第 00 行默认初始化为 00。
 * 输出：输出是最后一个状态，即：dp[len][m][n]。
 *
 */
public class FindMaxForm_n474 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        int[][][] dp=new int[len+1][m+1][n+1];
        for (int i=1;i<=len;i++){
            String s=strs[i-1];
            int[] count = count(s);
            int zero=count[0];
            int one=count[1];
            for (int j=0;j<=m;j++){
                for (int k=0;k<=n;k++){
                    dp[i][j][k]=dp[i-1][j][k];
                    if (j>=zero&&k>=one){
                        dp[i][j][k]=Math.max(dp[i-1][j][k],dp[i-1][j-zero][k-one]+1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }
    static int[] count(String s){
        int one=0;
        int zero=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='0') zero++;
            else one++;
        }
        return new int[]{zero,one};
    }

    public static void main(String[] args) {
        String[] str={"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(str,5,3));
    }
}
