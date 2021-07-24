package leetcode.dp;

import java.util.Arrays;

/**
 * @program: first
 * @description: 零钱兑换
 * @author: panhao
 * @date: 2021-07-23 16:29
 **/
public class CoinChange_n322 {
    public int coinChange(int[] coins, int amount) {
        int len=coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for (int i=0;i<=amount;i++){
            for (int j=0;j<len;j++){

            }
        }
        return dp[amount];
    }
}
