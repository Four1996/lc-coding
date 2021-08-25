package leetcode.double_pointer;

/**
 * @program: first
 * @description: 接雨水,双指针
 * @author: panhao
 * @date: 2021-08-21 22:18
 **/
public class Trap_n42_3 {
    public static int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        int max_left = 0, max_right = 0;
        int left = 0, right = len - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= max_left) {
                    max_left = height[left];
                } else {
                    ans += max_left - height[left];
                }
                left++;
            } else {
                if (height[right] >= max_right) {
                    max_right = height[right];
                } else {
                    ans += max_right -height[right];
                }
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={2,0,2};
        System.out.println(trap(nums));
    }
}
