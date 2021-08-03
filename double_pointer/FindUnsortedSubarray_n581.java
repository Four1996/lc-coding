package leetcode.double_pointer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 最短无序连续子数组
 * @author: panhao
 * @date: 2021-08-03 09:03
 **/
public class FindUnsortedSubarray_n581 {
    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int end = -1, start = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            if (nums[len - 1 - i] > min) {
                start = len - 1 - i;
            } else {
                min = nums[len - 1 - i];
            }
        }
        if (end == -1) return 0;
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums={1,3,2,4,5};
        System.out.println(findUnsortedSubarray(nums));
    }
}
