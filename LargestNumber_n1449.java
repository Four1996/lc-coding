package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年06月12日 9:19 上午
 */
public class LargestNumber_n1449 {
    public String largestNumber(int[] cost, int target) {
        int[][] dp=new int[10][target+1];
        for (int i = 0; i <10; i++){
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        int[][] from=new int[10][target+1];
        dp[0][0]=0;
        for (int i=0;i<9;i++){
            int c=cost[i];
            for (int j=0;j<=target;j++){
                if (j<c){
                    dp[i+1][j]=dp[i][j];
                    from[i+1][j]=j;
                }else{
                    if (dp[i][j]>dp[i+1][j-c]+1){
                        dp[i+1][j]=dp[i][j];
                        from[i+1][j]=j;
                    }else{
                        dp[i+1][j]=dp[i+1][j-c]+1;
                        from[i+1][j]=j-c;
                    }
                }
            }
        }
        if (dp[9][target]<0){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        int i=9,j=target;
        while (i>0){
            if (j==from[i][j]) i--;
            else{
                sb.append(i);
                j=from[i][j];
            }
        }
        return sb.toString();
    }
}
