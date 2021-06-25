package leetcode.swordoffer;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年06月05日 9:41 上午
 */
public class TwoSum_n1982 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) return new int[]{map.get(num),num};
            else{
                map.put(target-num,num);
            }
        }
        return null;
    }
}
