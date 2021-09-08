package leetcode.heap;

import java.util.*;

/**
 * @program: first
 * @description: 和最小的k个数对
 * @author: panhao
 * @date: 2021-09-07 16:35
 **/
public class kSmallestPairs_n2175 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int n1 = o1.get(0) + o1.get(1);
                int n2 = o2.get(0) + o2.get(1);
                return n2- n1;
            }
        });
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                if (queue.isEmpty() || queue.size() < k) {
                    queue.add(new ArrayList<>(Arrays.asList(n1, n2)));
                } else {
                    if ((queue.peek().get(0) + queue.peek().get(1)) > (n1 + n2)) {
                        queue.add(new ArrayList<>(Arrays.asList(n1, n2)));
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
