package leetcode;

/**
 * @program: first
 * @description: 接雨水,动态规划
 * @author: panhao
 * @date: 2021-08-21 22:18
 **/
public class Trap_n42_2 {
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        int[] max_left = new int[len];
        for (int i = 1; i < len; i++) {
            max_left[i] = Math.max(height[i - 1], max_left[i - 1]);
        }
        int[] max_right = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 0; i < len; i++) {
            int max = Math.min(max_right[i], max_left[i]);
            if (max > height[i]) {
                ans += max - height[i];
            }
        }
        return ans;
    }
}
