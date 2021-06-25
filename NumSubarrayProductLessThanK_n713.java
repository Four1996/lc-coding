package leetcode;

import java.util.HashSet;

/**
 * @author panhao
 * @date 2021年06月02日 11:00 上午
 */
public class NumSubarrayProductLessThanK_n713 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k==0||k==1) return 0;
        int ans=0;
        int left=0,right=0;
        int product=1;
        while (right<nums.length){
            product*=nums[right];
            while (product>=k&&left<nums.length){
                product/=nums[left];
                left++;
            }
            ans+=right-left+1;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(numSubarrayProductLessThanK(nums,0));
    }
}
