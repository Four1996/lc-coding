package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author panhao
 * @date 2021年06月11日 8:59 上午
 *
 *
 * 朴素解法
 */
public class NumSquares_n279_2 {
    public int numSquares(int n) {
        List<Integer> list=new ArrayList<>();
        int num=1;
        while (num*num<=n){
            list.add(num*num);
            num++;
        }
        int len=list.size();
        int[][] dp=new int[len+1][n+1];
//        for (int j=0;j<=n;j++){
//            int t=list.get(1);
//        }
        Arrays.fill(dp[0],Integer.MAX_VALUE);
        dp[0][0]=0;
//        Arrays.fill(dp,-1);
        for (int i=1;i<=len;i++){
            int squire=list.get(i-1);
            for (int j=0;j<=n;j++){
                dp[i][j]=dp[i-1][j];
                for (int k=1;k*squire<=j;k++){
                    if (dp[i-1][j-k*squire]!=Integer.MAX_VALUE){
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][j-k*squire]+k);
                    }
                }
            }
        }
        return dp[len][n];
    }

    public static void main(String[] args) {
        System.out.println(new NumSquares_n279_2().numSquares(12));
    }
}
