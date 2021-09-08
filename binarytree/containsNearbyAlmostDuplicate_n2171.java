package leetcode.binarytree;

import java.util.TreeSet;

/**
 * @program: first
 * @description: 值和下标之差都在给定的范围内
 * @author: panhao
 * @date: 2021-09-07 14:44
 **/
public class containsNearbyAlmostDuplicate_n2171 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            long u = nums[i] * 1L;
            Long floor = set.floor(u);
            Long ceiling = set.ceiling(u);
            if (floor != null && u - floor <= t) {
                return true;
            }
            if (ceiling != null && ceiling - u <= t) {
                return true;
            }
            set.add(u);
            if (i >= k) {
                set.remove(nums[i - k] * 1L);
            }
        }
        return false;
    }
}
