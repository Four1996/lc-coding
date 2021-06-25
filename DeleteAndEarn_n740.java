package leetcode;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月05日 10:17 上午
 */
public class DeleteAndEarn_n740 {
    public static int deleteAndEarn(int[] nums) {
        int len=nums.length;
        int[] cost=new int[10009];
        int count=0;
        for (int i=0;i<len;++i){
            cost[nums[i]]++;
            count=Math.max(nums[i],count);
        }
        int[][] dp=new int[count+1][2];
        for (int i=1;i<=count;i++){
            dp[i][0]=dp[i-1][1]+cost[i]*i;
            dp[i][1]= Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[count][0],dp[count][1]);
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,7,8,8,10,10,10};
        System.out.println(deleteAndEarn(nums));
    }
}
