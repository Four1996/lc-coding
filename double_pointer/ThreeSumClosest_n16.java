package leetcode.double_pointer;

import java.util.Arrays;

/**
 * @program: first
 * @description: 最接近的三数之和
 * @author: panhao
 * @date: 2021-08-25 17:01
 **/
public class ThreeSumClosest_n16 {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 30000;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = len - 1, sum;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(target - ans) > Math.abs(sum - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}
