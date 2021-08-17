package leetcode.prefix_sum;

import java.util.HashMap;

/**
 * @program: first
 * @description: 和为k的子数组
 * @author: panhao
 * @date: 2021-08-17 10:26
 **/
public class SubarraySum_n2097 {
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= len; i++) {
            if (map.containsKey(sum[i] - k)) {
                ans += map.get(sum[i] - k);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,-1,0};
        System.out.println(subarraySum(nums,0));
    }
}
