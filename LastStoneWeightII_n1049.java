package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年06月08日 8:57 上午
 */
public class LastStoneWeightII_n1049 {

    public int lastStoneWeightII(int[] stones) {
        int len=stones.length;
        int sum=0;
        for (int stone : stones) {
            sum+=stone;
        }
        int maxBag=sum/2;
        boolean[][] dp=new boolean[len+1][maxBag+1];
        dp[0][0]=true;
        for (int i=1;i<=len;i++){
            for (int j=0;j<=maxBag;j++){
                dp[i][j]=dp[i-1][j];
                if (stones[i-1]<=j){
                    dp[i][j]=dp[i][j]||dp[i-1][j-stones[i-1]];
                }
            }
        }
        for (int j=maxBag;;--j){
            if (dp[len][j]) return sum-2*j;
        }
    }
}
