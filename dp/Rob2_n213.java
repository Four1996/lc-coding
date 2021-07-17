package leetcode.dp;

import java.util.Arrays;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-16 16:05
 **/
public class Rob2_n213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int sum1 = robSum(Arrays.copyOfRange(nums, 0, len - 1));
        int sum2 = robSum(Arrays.copyOfRange(nums, 1, len));
        return Math.max(sum1, sum2);
    }

    int robSum(int[] nums) {
        int len = nums.length;
        int pre = 0, cur = 0, temp;
        for (int i = 0; i < len; i++) {
            temp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(new Rob2_n213().rob(nums));
    }
}
