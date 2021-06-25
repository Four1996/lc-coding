package leetcode;

/**
 * @author panhao
 * @date 2021年05月13日 8:31 上午
 */
public class NumWays_n1269 {
    static final int val=(int)1e9+7;
    public int numWays(int steps, int arrLen) {
        int len = arrLen;
        int[][] dp = new int[steps + 1][len];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; ++i) {
            for (int j = 0; j < len;j++ ) {
                dp[i][j]=dp[i-1][j];
                if (j >0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1])%val;
                if(j<len-1) dp[i][j]=(dp[i][j]+dp[i-1][j+1])%val;
            }
        }
        return dp[steps][0];
    }

    public static void main(String[] args) {
        NumWays_n1269 n=new NumWays_n1269();
        System.out.println(n.numWays(430,148488));
    }
}
