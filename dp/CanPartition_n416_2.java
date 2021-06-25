package leetcode.dp;

/**
 * @author panhao
 * @date 2021年06月14日 3:10 下午
 */
public class CanPartition_n416_2 {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target=sum/2;
        boolean[] dp=new boolean[target+1];
        if (nums[0]<=target) dp[nums[0]]=true;
        dp[0]=true;
        for (int i=1;i<nums.length;i++){
            for (int j=target;nums[i]<=j;j--){
                if (dp[target]){
                    return true;
                }
                dp[j]=dp[j-nums[i]]||dp[j];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        System.out.println(canPartition(nums));
    }
}
