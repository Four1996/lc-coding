package leetcode.heap;

import java.util.*;

/**
 * @program: first
 * @description: 出现频率最高的k个数字
 * @author: panhao
 * @date: 2021-09-07 16:11
 **/
public class topKFrequent_n2174 {
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            int times = count.getOrDefault(num, 0) + 1;
            count.put(num, times);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (queue.isEmpty() || queue.size() < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (queue.peek()[1] < entry.getValue()) {
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                    queue.poll();
                }
            }
        }
        int[] ans = new int[queue.size()];
        int idx = queue.size() - 1;
        while (!queue.isEmpty()) {
            ans[idx--] = queue.poll()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent(nums, 2));
    }
}
