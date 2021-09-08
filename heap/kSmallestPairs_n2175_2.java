package leetcode.heap;

import java.util.*;

/**
 * @program: first
 * @description: 和最小的k个数对
 * @author: panhao
 * @date: 2021-09-07 16:35
 **/
public class kSmallestPairs_n2175_2 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int n1 = o1.get(0) + o1.get(1);
                int n2 = o2.get(0) + o2.get(1);
                return n2 - n1;
            }
        });
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                if (queue.isEmpty() || queue.size() < k) {
                    queue.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
                } else {
                    if ((queue.peek().get(0) + queue.peek().get(1)) > (nums1[i] + nums2[j])) {
                        queue.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
                        queue.poll();
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            ans.add(0, queue.poll());
        }
        return ans;
    }
}
