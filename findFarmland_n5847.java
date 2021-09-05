package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-04 22:39
 **/
public class findFarmland_n5847 {
    boolean[][] vis;
    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int row, col;
    int minR, minC, maxR, maxC;

    public int[][] findFarmland(int[][] land) {
        row = land.length;
        col = land[0].length;
        vis = new boolean[row][col];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!vis[i][j] && land[i][j] == 1) {
                    maxR = -1;
                    maxC = -1;
                    minR = Integer.MAX_VALUE;
                    minC = Integer.MAX_VALUE;
                    dfs(land, i, j);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(minR);
                    temp.add(minC);
                    temp.add(maxR);
                    temp.add(maxC);
                    ans.add(temp);
                }
            }
        }
        int[][] res = new int[ans.size()][4];
        int idx = 0;
        for (List<Integer> an : ans) {
            res[idx][0] = an.get(0);
            res[idx][1] = an.get(1);
            res[idx][2] = an.get(2);
            res[idx][3] = an.get(3);
            idx++;
        }
        return res;
    }

    public void dfs(int[][] land, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || vis[r][c] || land[r][c] == 0) {
            return;
        }
        vis[r][c] = true;
        maxR = Math.max(maxR, r);
        maxC = Math.max(maxC, c);
        minR = Math.min(minR, r);
        minC = Math.min(minC, c);
        for (int[] ints : dir) {
            int x = r + ints[0];
            int y = c + ints[1];
            dfs(land, x, y);
        }
    }

    public static void main(String[] args) {
        findFarmland_n5847 f=new findFarmland_n5847();
        int[][] land={
                {1,0,0},{0,1,1},{0,1,1}
        };
        System.out.println(f.findFarmland(land));
    }
}
