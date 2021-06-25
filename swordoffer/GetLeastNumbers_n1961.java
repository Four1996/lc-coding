package leetcode.swordoffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author panhao
 * @date 2021年05月30日 9:16 下午
 */
public class GetLeastNumbers_n1961 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k==0) return new int[k];
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i : arr) {
            if (queue.size()<k)queue.add(i);
            else{
                if (i<queue.peek()){
                    queue.add(i);
                    queue.poll();
                }
            }
        }
        int[] ans=new int[k];
        int idx=0;
        while (!queue.isEmpty()){
            ans[idx++]=queue.poll();
        }
        return ans;
    }
}
