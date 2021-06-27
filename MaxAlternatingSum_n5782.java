package leetcode;

import java.util.Stack;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-06-26 22:50
 **/
public class MaxAlternatingSum_n5782 {
    public static long maxAlternatingSum(int[] nums) {
        long diff = 0;
        int i = 0, j;
        int len = nums.length;
        while (i < len) {
            j = i;
            while (i + 1 < len && nums[i + 1] < nums[i]) i++;
            diff += nums[j] - (i + 1 < len ? nums[i] : 0);
            i++;
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] nums={4,2,5,3};
        System.out.println(maxAlternatingSum(nums));
    }
}
