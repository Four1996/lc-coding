package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description: 雪糕的最大数量
 * @author: panhao
 * @date: 2021-07-02 09:14
 **/
public class MaxIceCream_n1833_2 {
    public static int maxIceCream(int[] costs, int coins) {
        int len=costs.length;
        int[][] dp=new int[len+1][coins+1];
        for (int i=1;i<=len;i++){
            for (int j=1;j<=coins;j++){
                dp[i][j]=dp[i-1][j];
                if (costs[i-1]>j) continue;
                dp[i][j]= Math.max(dp[i][j],dp[i-1][j-costs[i-1]]+1);
            }
        }
        return dp[len][coins];
    }

    public static void main(String[] args) {
        int[] costs={1,6,3,1,2,5};
        System.out.println(maxIceCream(costs,20));
    }
}
