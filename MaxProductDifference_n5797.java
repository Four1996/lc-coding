package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-06-27 10:30
 **/
public class MaxProductDifference_n5797 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        long max=nums[len-1]*nums[len-2];
        long min=nums[0]*nums[1];
        return (int) (max-min);
    }
}
