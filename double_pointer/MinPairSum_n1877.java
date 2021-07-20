package leetcode.double_pointer;

import java.util.Arrays;

/**
 * @program: first
 * @description: 数组中最大数对和的最小值
 * @author: panhao
 * @date: 2021-07-20 18:45
 **/
public class MinPairSum_n1877 {
    public int minPairSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int left = 0, right = len - 1;
        int ans = 0;
        while (left < right) {
            ans = Math.max(nums[left++] + nums[right--], ans);
        }
        return ans;
    }
}
