package leetcode;

/**
 * @author panhao
 * @date 2021年06月11日 8:59 上午
 */
public class NumSquares_n279 {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for (int i=1;i<=n;i++){
            dp[i]=i;
            for (int j=1;(i-j*j)>=0;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumSquares_n279().numSquares(12));
    }
}
