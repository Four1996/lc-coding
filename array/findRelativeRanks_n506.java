package leetcode.array;

import java.util.PriorityQueue;

/**
 * @program: first
 * @description: 相对名次
 * @author: panhao
 * @date: 2021-12-02 10:31
 **/
public class findRelativeRanks_n506 {
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        String[] ans = new String[len];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < len; i++) {
            queue.add(new int[]{score[i], i + 1});
        }
        int idx = 1;
        while (queue.size() > 0) {
            int[] poll = queue.poll();
            if (idx == 1) {
                ans[poll[1]] = "Gold Medal";
            } else if (idx == 2) {
                ans[poll[1]] = "Silver Medal";
            } else if (idx == 3) {
                ans[poll[1]] = "Bronze Medal";
            } else {
                ans[poll[1]] = len - queue.size() + "";
            }
            idx++;
        }
        return ans;
    }
}
