package leetcode.prefix_sum;

import java.util.HashMap;

/**
 * @program: first
 * @description: 和相同的二元子数组
 * @author: panhao
 * @date: 2021-07-08 08:45
 **/
public class NumSubarraysWithSum_n930 {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            ans += map.getOrDefault(sum - goal, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(nums, 2));
    }
}
