package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author panhao
 * @date 2021年05月20日 2:08 下午
 */
public class FindKthLargest_n215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for (int i:nums){
            queue.add(i);
            if (queue.size()>k) queue.poll();
        }
        return queue.poll();
    }
}
