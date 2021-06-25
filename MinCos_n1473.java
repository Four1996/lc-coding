package leetcode;

/**
 * @author panhao
 * @date 2021年05月04日 9:23 上午
 */
public class MinCos_n1473 {
    int INF = 0x3f3f3f3f;
    public int minCost(int[] hs, int[][] cost, int m, int n, int t) {
        int[][][] f = new int[m + 1][n + 1][t + 1];

        // 不存在分区数量为 0 的状态
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j][0] = INF;
            }
        }

        for (int i = 1; i <= m; i++) {
            int color = hs[i - 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= t; k++) {
                    // 形成分区数量大于房子数量，状态无效
                    if (k > i) {
                        f[i][j][k] = INF;
                        continue;
                    }

                    // 第 i 间房间已经上色
                    if (color != 0) {
                        if (j == color) { // 只有与「本来的颜色」相同的状态才允许被转移
                            int tmp = INF;
                            // 先从所有「第 i 间房形成新分区」方案中选最优（即与上一房间颜色不同）
                            for (int p = 1; p <= n; p++) {
                                if (p != j) {
                                    tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                                }
                            }
                            // 再结合「第 i 间房不形成新分区」方案中选最优（即与上一房间颜色相同）
                            f[i][j][k] = Math.min(f[i - 1][j][k], tmp);

                        } else { // 其余状态无效
                            f[i][j][k] = INF;
                        }

                        // 第 i 间房间尚未上色
                    } else {
                        int u = cost[i - 1][j - 1];
                        int tmp = INF;
                        // 先从所有「第 i 间房形成新分区」方案中选最优（即与上一房间颜色不同）
                        for (int p = 1; p <= n; p++) {
                            if (p != j) {
                                tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                            }
                        }
                        // 再结合「第 i 间房不形成新分区」方案中选最优（即与上一房间颜色相同）
                        // 并将「上色成本」添加进去
                        f[i][j][k] = Math.min(tmp, f[i - 1][j][k]) + u;
                    }
                }
            }
        }

        // 从「考虑所有房间，并且形成分区数量为 t」的所有方案中找答案
        int ans = INF;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, f[m][i][t]);
        }
        return ans == INF ? -1 : ans;
    }


}
