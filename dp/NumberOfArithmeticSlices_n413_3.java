package leetcode.dp;

/**
 * @program: first
 * @description: 等差数列划分
 * @author: panhao
 * @date: 2021-07-17 10:37
 **/
public class NumberOfArithmeticSlices_n413_3 {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int len = nums.length;
        int cur, pre = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                cur = pre + 1;
                pre = cur;
                ans += cur;
            } else {
                cur = 0;
                pre = cur;
            }
        }
        return ans;
    }
}
