package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @program: first
 * @description: 两数之和
 * @author: panhao
 * @date: 2021-07-24 21:31
 **/
public class TwoSum_n1_2 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
