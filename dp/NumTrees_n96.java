package leetcode.dp;

/**
 * @author panhao
 * @date 2021年06月01日 9:59 上午
 */
public class NumTrees_n96 {
    public int numTrees(int n) {
        if (n==0) return 0;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<n+1;i++){
            for (int j=1;j<i+1;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
