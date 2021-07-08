package leetcode.double_pointer;

import javafx.scene.effect.Effect;

/**
 * @program: first
 * @description: 长度最小的子数组
 * @author: panhao
 * @date: 2021-07-07 16:21
 **/
public class minSubArrayLen_n209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        int left = 0, right = 0;
        int sum = 0;
        while (right < len) {
            while (right < len && sum < target) {
                sum += nums[right++];
            }
            if (sum >= target) ans = Math.min(right - left, ans);
            while (left < len && sum >= target) {
                sum -= nums[left++];
                if (sum >= target) ans = Math.min(right - left, ans);
            }
        }
        if (ans == Integer.MAX_VALUE) return 0;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(11,nums));
    }
}
