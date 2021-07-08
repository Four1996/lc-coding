package leetcode.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 环形子数组的最大和
 * @author: panhao
 * @date: 2021-07-07 22:27
 **/
public class MaxSubarraySumCircular_n918 {
    public int maxSubarraySumCircular(int[] nums) {

        int len = nums.length;
        int[] presum = new int[len * 2 + 1];
        for (int i = 0; i < len * 2; i++) {
            presum[i + 1] = presum[i] + nums[i % len];
        }
        int ans = nums[0];
        Deque<Integer> deque = new ArrayDeque();
        deque.offer(0);
        for (int j = 1; j <= 2 * len; ++j) {
            // If the smallest i is too small, remove it.
            if (deque.peekFirst() < j - len)
                deque.pollFirst();

            // The optimal i is deque[0], for cand. answer P[j] - P[i].
            ans = Math.max(ans, presum[j] - presum[deque.peekFirst()]);

            // Remove any i1's with P[i2] <= P[i1].
            while (!deque.isEmpty() && presum[j] <= presum[deque.peekLast()])
                deque.pollLast();

            deque.offerLast(j);
        }


        return ans;
    }
}
