package leetcode.prefix_sum;

/**
 * @program: first
 * @description: 左右两边子数组的和相等
 * @author: panhao
 * @date: 2021-08-19 08:53
 **/
public class PivotIndex_n2100 {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int ans = -1;
        for (int i = 1; i <= len; i++) {
            if (preSum[i - 1] - preSum[0] == preSum[len] - preSum[i]) {
                ans = i;
                break;
            }
        }
        return ans == -1 ? ans : ans - 1;
    }
}
