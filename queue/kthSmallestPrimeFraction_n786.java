package leetcode.queue;

import java.util.PriorityQueue;

/**
 * @program: first
 * @description: 第K个最小的素数分数
 * @author: panhao
 * @date: 2021-11-29 14:10
 **/
public class kthSmallestPrimeFraction_n786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[0] * 1.0 / b[1], a[0] * 1.0 / a[1]));
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (queue.size() < k) {
                    queue.add(new int[]{arr[i], arr[j]});
                } else {
                    if ((arr[i] * 1.0 / arr[j]) / arr[j] < (queue.peek()[0] * 1.0 / queue.peek()[1])) {
                        queue.add(new int[]{arr[i], arr[j]});
                        queue.poll();
                    }
                }
            }
        }
        return queue.poll();
    }
}
