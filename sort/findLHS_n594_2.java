package leetcode.sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: first
 * @description: 最长和谐子序列
 * @author: panhao
 * @date: 2021-11-20 11:14
 **/
public class findLHS_n594_2 {
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key - 1)) {
                ans = Math.max(map.get(key) + map.get(key - 1), ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHS(nums));
    }
}
