package leetcode.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: first
 * @description: 0和1个数相同的子数组
 * @author: panhao
 * @date: 2021-08-17 14:17
 **/
public class FindMaxLength_n2098 {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, -1);
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num == 1) {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                int preIdx = map.get(count);
                ans = Math.max(i - preIdx, ans);
            } else {
                map.put(count, i);
            }
        }
        return ans;
    }
}
