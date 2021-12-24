package leetcode.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: first
 * @description: 吃苹果的最大数目
 * @author: panhao
 * @date: 2021-12-24 20:46
 **/
public class eatenApples_n1705 {
    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        int len = apples.length;
        int time = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        while (time < len || !queue.isEmpty()) {
            if (time < len && apples[time] > 0) {
                queue.add(new int[]{time + days[time] - 1, apples[time]});
            }
            while (!queue.isEmpty() && queue.peek()[0] < time) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                int[] cur = queue.poll();
                cur[1]--;
                if (cur[1] > 0 && cur[0] > time) {
                    queue.add(cur);
                }
                ans++;
            }
            time++;
        }
        return ans;
    }
}
