package leetcode.slidingwindow;

/**
 * @program: first
 * @description: 乘积小于K的子数组
 * @author: panhao
 * @date: 2021-08-11 11:01
 **/
public class NumSubarrayProductLessThanK_n2090 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        int left = 0, right = 0, pro = 1;
        while (right < len) {
            pro *= nums[right];
            while (left <= right && pro >= k) {
                pro /= nums[left];
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
