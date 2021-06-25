package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月24日 6:28 下午
 */
public class CombinationSum4_n377 {
    public int combinationSum4(int[] nums,int target){
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i=1;i<=target;i++){
            for (int num:nums){
                if (num<=i) dp[i]+=dp[i-num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        CombinationSum4_n377 c=new CombinationSum4_n377();
        System.out.println(c.combinationSum4(nums,4));
    }
}
