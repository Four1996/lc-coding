package leetcode.dp;

/**
 * @program: first
 * @description: 乘积为整数的最长子数组长度
 * @author: panhao
 * @date: 2021-07-08 20:45
 **/
public class GetMaxLen_n1567 {
    public static int getMaxLen(int[] nums) {
        int len=nums.length;
        int[][] dp=new int[len][2];
        int ans=0;
        if (nums[0]>0) dp[0][0]=1;
        else if (nums[0]<0) dp[0][1]=1;
        ans=Math.max(ans,dp[0][0]);
        for (int i=1;i<len;i++){
            if (nums[i]>0){
                dp[i][0]=dp[i-1][0]+1;
                if (dp[i-1][1]>0) dp[i][1]=dp[i-1][1]+1;
                else dp[i][1]=0;
            }else if (nums[i]<0){
                if (dp[i-1][1]>0) dp[i][0]=dp[i-1][1]+1;
                else dp[i][0]=0;
                dp[i][1]=dp[i-1][0]+1;
            }
            ans=Math.max(ans,dp[i][0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1000000000};
        System.out.println(getMaxLen(nums));
    }
}
