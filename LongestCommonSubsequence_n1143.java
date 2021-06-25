package leetcode;

/**
 * @author panhao
 * @date 2021年04月03日 10:01 上午
 */
public class LongestCommonSubsequence_n1143 {
    public static int longestCommonSubsequence(String text1,String text2){
        int ans=0;
        int l1=text1.length(),l2=text2.length();
        if (l1==0||l2==0) return 0;
        int[][] dp=new int[l2+1][l1+1];
//      for (int i=0;i<l2;i++) dp[0][i]=0;
        for(int i=1;i<=l2;i++) {
            for (int j=1;j<=l1;j++){
                if (text1.charAt(j-1)==text2.charAt(i-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{//当 text1[i - 1] != text2[j - 1]时，说明两个子字符串的最后一位不相等，那么此时的状态
                    // dp[i][j] 应该是 dp[i - 1][j] 和 dp[i][j - 1] 的最大值。
                    // 举个例子，比如对于 ace和 bc而言，他们的最长公共子序列的长度等于
                    // ① ace 和 b 的最长公共子序列长度0 与 ② ac 和 bc
                    // 的最长公共子序列长度1 的最大值，即 1。
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        ans=dp[l2][l1];
        return ans;
    }

    public static void main(String[] args) {
        String text1="abc";
        String text2="def";
        System.out.println(longestCommonSubsequence(text1,text2));
    }
}
