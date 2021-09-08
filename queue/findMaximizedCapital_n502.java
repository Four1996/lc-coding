package leetcode.queue;

import java.util.*;

/**
 * @program: first
 * @description: IPO
 * @author: panhao
 * @date: 2021-09-08 09:41
 **/
public class findMaximizedCapital_n502 {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        int[][] nums = new int[len][2];
        for (int i = 0; i < len; i++) {
            nums[i][0] = capital[i];
            nums[i][1] = profits[i];
        }
        Arrays.sort(nums, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int cur = 0;
        while (k > 0) {
            while (cur < len && nums[cur][0] <= w) {
                queue.add(nums[cur++][1]);
            }
            if (!queue.isEmpty()) {
                w += queue.poll();
            } else {
                break;
            }
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3};
        int[] nums2={0,1,2};
        System.out.println(findMaximizedCapital(1,0,nums1,nums2));
    }
}
