package leetcode;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-05 10:30
 **/
public class countQuadruplets_n5863 {
    public int countQuadruplets(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    for (int l = k + 1; l < nums.length; l++) {
                        if (sum == nums[l]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
