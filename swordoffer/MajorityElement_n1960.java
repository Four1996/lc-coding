package leetcode.swordoffer;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年05月30日 9:13 下午
 */
public class MajorityElement_n1960 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int index=nums.length/2;
        return nums[index];
    }
}
