package leetcode.array;

import java.util.Arrays;

/**
 * @program: first
 * @description: 统计特殊四元组
 * @author: panhao
 * @date: 2021-12-29 21:27
 **/
public class countQuadruplets_n1995 {
    public int countQuadruplets(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    for (int l = k + 1; l < len; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
