package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-29 10:30
 **/
public class MinimumDifference_n5854 {
    public int minimumDifference(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        if (k == 1) {
            return 0;
        }
        int left=0,right=left+k-1;
        int min = Integer.MAX_VALUE;
        while (right<len){
            min = Math.min(nums[right] - nums[left], min);
            left++;
            right=left+k-1;
        }
        return min;
    }
}
