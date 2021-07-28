package leetcode.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @program: first
 * @description: 132模式
 * @author: panhao
 * @date: 2021-07-28 19:23
 **/
public class Find132pattern_n456 {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        Deque<Integer> deque = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (deque.isEmpty()) deque.addFirst(nums[i]);
            else {
                if (nums[i] < k) return true;
                while (!deque.isEmpty() && nums[i] > deque.peekFirst()) {
                    k = Math.max(k, deque.pollFirst());
                }
                deque.addFirst(nums[i]);
            }
        }
        return false;
    }
}
