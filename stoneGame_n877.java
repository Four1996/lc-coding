package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author panhao
 * @date 2021年06月16日 8:55 上午
 */
public class stoneGame_n877 {
    static Deque<Integer> deque;
    static int res;

    public static boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,7,2,3};
        System.out.println(stoneGame(nums));
    }
}
