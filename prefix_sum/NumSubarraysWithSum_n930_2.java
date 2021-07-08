package leetcode.prefix_sum;

import java.util.HashMap;

/**
 * @program: first
 * @description: 和相同的二元子数组
 * @author: panhao
 * @date: 2021-07-08 08:45
 **/
public class NumSubarraysWithSum_n930_2 {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int len=nums.length;
        int left=0,right=0,sum=0;
        int ans=0;
        while (right<len){
            sum+=nums[right];
            while (left<right){}
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(nums, 2));
    }
}
