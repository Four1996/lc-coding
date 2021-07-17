package leetcode.dp;

/**
 * @program: first
 * @description: 等差数列划分
 * @author: panhao
 * @date: 2021-07-17 10:37
 **/
public class NumberOfArithmeticSlices_n413_4 {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int d = nums[i + 1] - nums[i];
            for (int j = i + 2; j < len; j++) {
                if (nums[j] - nums[j - 1] == d) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
