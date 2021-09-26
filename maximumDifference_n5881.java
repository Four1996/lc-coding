package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-26 10:30
 **/
public class maximumDifference_n5881 {
    public int maximumDifference(int[] nums) {
        int len=nums.length;
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[j]>nums[i]){
                    ans=Math.max(nums[j]-nums[i],ans);
                }
            }
        }
        return ans==Integer.MIN_VALUE?-1:ans;
    }
}
