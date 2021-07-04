package leetcode;

import java.util.PriorityQueue;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-04 10:32
 **/
public class EliminateMaximum_n5801 {
    public static int eliminateMaximum(int[] dist, int[] speed) {
        int ans = 0;
        int len = dist.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            int time = (dist[i] - 1) / speed[i];
            queue.add(time);
        }
        int round = 0;
        while (!queue.isEmpty() ) {
            if (queue.peek()<round) return ans;
            queue.remove();
            ans++;
            round++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] dist={4,2,3};
        int[] speed={2,1,1};
        System.out.println(eliminateMaximum(dist,speed));
    }
}
