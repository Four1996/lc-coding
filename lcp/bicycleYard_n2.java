package leetcode.lcp;

import java.util.*;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-25 16:06
 **/
public class bicycleYard_n2 {
    int row, col;
    List<int[]> res;
    int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    boolean[][][] all;

    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        res = new ArrayList<>();
        row = terrain.length;
        col = terrain[0].length;
        all = new boolean[row][col][202];
        boolean[][][] vis = new boolean[row][col][202];
        vis[position[0]][position[1]][1] = true;
        for (int[] dir : dirs) {
            int x = position[0] + dir[0];
            int y = position[1] + dir[1];
            dfs(x, y, terrain, obstacle, terrain[position[0]][position[1]], 1, vis);
        }
        int idx = 0;
        int[][] ans = new int[res.size()][2];
        for (int[] re : res) {
            ans[idx][0] = re[0];
            ans[idx][1] = re[1];
            idx++;
        }
        Arrays.sort(ans, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        return ans;
    }

    void dfs(int r, int c, int[][] terrain, int[][] obstacle, int h1, int v, boolean[][][] vis) {
        if (r < 0 || r >= row || c < 0 || c >= col || vis[r][c][v]) {
            return;
        }
        vis[r][c][v] = true;
        int diff = h1 - terrain[r][c] - obstacle[r][c];
        if (v + diff <= 0) {
            return;
        }
        if (v + diff == 1 && !all[r][c][v + diff]) {
            res.add(new int[]{r, c});
            all[r][c][v + diff] = true;
        }
        for (int[] dir : dirs) {
            int x = dir[0];
            int y = dir[1];
            dfs(r + x, c + y, terrain, obstacle, terrain[r][c], v + diff, vis);
        }
    }
}
