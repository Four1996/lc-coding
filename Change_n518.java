package leetcode;

/**
 * @author panhao
 * @date 2021年06月10日 8:46 上午
 */
public class Change_n518 {


    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

}
