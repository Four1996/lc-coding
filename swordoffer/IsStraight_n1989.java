package leetcode.swordoffer;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年06月05日 9:24 下午
 */
public class IsStraight_n1989 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int cur=0;

        for (int i=0;i<4;i++){
            if (nums[i]==0) {
                cur++;
                continue;
            }
            if (nums[i]==nums[i+1]) return false;
        }
        return nums[4]-nums[cur]<5;
    }
}
