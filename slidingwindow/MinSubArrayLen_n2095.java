package leetcode.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @program: first
 * @description: 和大于等于Target的最短子数组
 * @author: panhao
 * @date: 2021-08-17 09:36
 **/
public class MinSubArrayLen_n2095 {
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0, right = left;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (right < len) {
            while (right < len && sum < target) {
                sum += nums[right];
                right++;
            }
            while (left <= right && sum >= target) {
                ans = Math.min(ans, right - left);
                sum -= nums[left++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
