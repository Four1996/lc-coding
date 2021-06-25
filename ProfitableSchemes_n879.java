package leetcode;

/**
 * @author panhao
 * @date 2021年06月09日 8:59 上午
 */
public class ProfitableSchemes_n879 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD= (int) (1e9+7);
        int g=group.length;
        int[][][] dp=new int[g+1][n+1][minProfit+1];
        dp[0][0][0]=1;
        for (int i=1;i<=g;i++){
            int mems=group[i-1];
            int earn=profit[i-1];
            for (int j=0;j<=n;j++){
                for (int k=0;k<=minProfit;k++){
                    if (j<mems){
                        dp[i][j][k]=dp[i-1][j][k];
                    }else {
                        dp[i][j][k]=(dp[i-1][j][k]+dp[i-1][j-mems][Math.max(0,k-earn)])%MOD;
                    }
                }
            }
        }
        int sum=0;
        for (int j=0;j<=n;j++){
            sum=(sum+dp[g][j][minProfit])%MOD;
        }
        return sum;
    }
}
