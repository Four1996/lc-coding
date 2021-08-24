package leetcode.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @program: first
 * @description: K站中转内最便宜的航班
 * @author: panhao
 * @date: 2021-08-24 09:18
 **/
public class FindCheapestPrice_n787 {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dp[to][steps]表示恰好通过steps次航班到达to结点所花费的最少步数。
        int MAX = (int) ((1e6) + 10000);
        int[][] dp = new int[n][k + 2];
        for (int[] ints : dp) {
            Arrays.fill(ints, MAX);
        }
        dp[src][0] = 0;
        for (int steps = 1; steps <= k + 1; steps++) {
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], cost = flight[2];
                dp[to][steps] = Math.min(dp[from][steps - 1] + cost, dp[to][steps]);
            }
        }
        int ans = MAX;
        for (int num : dp[dst]) {
            ans = Math.min(ans, num);
        }
        return ans == MAX ? -1 : ans;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}
        };
        System.out.println(findCheapestPrice(4, nums, 0, 3, 1));
    }
}
