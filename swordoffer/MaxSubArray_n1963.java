package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年05月30日 10:30 下午
 */
public class MaxSubArray_n1963 {

    public static int maxSubArray(int[] nums) {
        int max=nums[0],presum=nums[0];
        for (int i=1;i<nums.length;i++){
            if (presum+nums[i]>nums[i]) presum+=nums[i];
            else presum=nums[i];
            max=Math.max(max,presum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
