package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月14日 10:38 上午
 */
public class LengthOfLIS_n300 {
    public int lengthOfLIS(int[] nums){
        int len=nums.length;
        if (len<2) return len;
        int[] dp=new int[len];
        Arrays.fill(dp,1);
        for (int i=1;i<len;i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]) dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int ans=0;
        for (int i=0;i<len;i++){
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        LengthOfLIS_n300 lengthOfLIS_n300=new LengthOfLIS_n300();
        System.out.println(lengthOfLIS_n300.lengthOfLIS(nums));
    }
}
