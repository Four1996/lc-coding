package leetcode.sort;

import java.util.Arrays;

/**
 * @program: first
 * @description: 最长和谐子序列
 * @author: panhao
 * @date: 2021-11-20 11:14
 **/
public class findLHS_n594 {
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int ans = 0;
        int left = 0, right = 0;
        while (right < len) {
            while (left < right && nums[right] - nums[left] > 1) {
                left++;
            }
            if (nums[right] - nums[left] == 1) {
                ans = Math.max(ans, right - left + 1);
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHS(nums));
    }
}
