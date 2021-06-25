package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月29日 10:29 上午
 */
public class SubarraySum_n560_2 {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int pre=0;
        for (int num : nums) {
            pre+=num;
            if (map.containsKey(pre-k)) count+=map.get(pre-k);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums={3,4,7,2,-3,1,4,2};
        System.out.println(new SubarraySum_n560_2().subarraySum(nums,7));
    }
}
