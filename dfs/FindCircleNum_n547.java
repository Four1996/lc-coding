package leetcode.dfs;

import test.TextServlet;

/**
 * @program: first
 * @description: 省份数量
 * @author: panhao
 * @date: 2021-07-08 18:57
 **/
public class FindCircleNum_n547 {
    boolean[] vis;
    int row, col;

    public int findCircleNum(int[][] isConnected) {
        row = isConnected.length;
        col = isConnected[0].length;
        vis = new boolean[row];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            if (!vis[i]) {
                dfs(isConnected, i);
                ans++;
            }
        }
        return ans;
    }

    void dfs(int[][] isConnected, int r) {
        if (vis[r]) return;
        vis[r] = true;
        for (int i = r, j = 0; j < col; j++) {
            if (i != j && isConnected[i][j] == 1) {
                dfs(isConnected, j);
            }
        }
    }
}
