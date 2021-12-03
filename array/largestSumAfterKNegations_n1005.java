package leetcode.array;

import java.util.Arrays;

/**
 * @program: first
 * @description: K次去饭后最大化的数组和
 * @author: panhao
 * @date: 2021-12-03 17:19
 **/
public class largestSumAfterKNegations_n1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }
        if (k > 0) {
            Arrays.sort(nums);
            if (k % 2 == 0) {
                return sum;
            } else {
                return sum + (-nums[0]*2);
            }
        }
        return sum;
    }
}
