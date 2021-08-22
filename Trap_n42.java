package leetcode;

/**
 * @program: first
 * @description: 接雨水
 * @author: panhao
 * @date: 2021-08-21 22:18
 **/
public class Trap_n42 {
    public int trap(int[] height) {
        int ans = 0;
        int max = 0;
        int len = height.length;
        for (int i : height) {
            max = Math.max(i, max);
        }
        while (max > 0) {
            int left = -1;
            for (int i = 0; i < len; i++) {
                if (height[i] >= max) {
                    if (left != -1) {
                        ans += i - left - 1;
                    }
                    left = i;
                }
            }
            max--;
        }
        return ans;
    }
}
