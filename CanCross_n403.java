package leetcode;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

/**
 * @author panhao
 * @date 2021年04月29日 8:46 上午
 */
public class CanCross_n403 {

    private static Boolean[][] rec;

    public static boolean canCross(int[] stones) {
        int n = stones.length;
        rec = new Boolean[n][n];
        return dfs(stones, 0, 0);
    }

    private static boolean dfs(int[] stones, int i, int lastDis) {
        if (i == stones.length - 1) {
            return true;
        }
        if (rec[i][lastDis] != null) {
            return rec[i][lastDis];
        }

        for (int curDis = lastDis - 1; curDis <= lastDis + 1; curDis++) {
            if (curDis > 0) {
                int j = Arrays.binarySearch(stones, i + 1, stones.length, curDis + stones[i]);
                if (j >= 0 && dfs(stones, j, curDis)) {
                    return rec[i][lastDis] = true;
                }
            }
        }
        return rec[i][lastDis] = false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCross(nums));
    }
}
