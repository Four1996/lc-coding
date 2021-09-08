package leetcode.heap;

import java.util.PriorityQueue;

/**
 * @program: first
 * @description: 数据流的第K大数值
 * @author: panhao
 * @date: 2021-09-07 15:59
 **/
public class KthLargest_n2173 {
    PriorityQueue<Integer> q;
    int size;

    public KthLargest_n2173(int k, int[] nums) {
        size = k;
        q = new PriorityQueue<>();
        for (int num : nums) {
            if (q.isEmpty() || q.size() < k) {
                q.add(num);
            } else {
                if (num > q.peek()) {
                    q.add(num);
                    q.poll();
                }
            }
        }
    }

    public int add(int val) {
        if (q.isEmpty() || q.size() < size) {
            q.add(val);
        } else {
            if (val > q.peek()) {
                q.add(val);
                q.poll();
            }
        }
        return q.peek();
    }
}
