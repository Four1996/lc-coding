package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-06-20 11:34
 **/
public class CountSubIslands_n5791 {
    boolean[][] vis;
    int row, col;
    boolean tag = true;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        row = grid1.length;
        col = grid1[0].length;
        vis = new boolean[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid2[i][j] == 1 && vis[i][j] == false) {
                    tag = true;
                    dfs(grid1, grid2, i, j);
                    if (tag) ans++;
                }
            }
        }

        return ans;
    }

    void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid2[i][j] == 0 || vis[i][j] == true) return;
        vis[i][j] = true;
        if (grid1[i][j] == 0) {
            // 这里不能直接return，一定要将该块岛屿全部遍历完再结束，否则会出错。
            tag = false;
        }
        dfs(grid1, grid2, i + 1, j);
        dfs(grid1, grid2, i - 1, j);
        dfs(grid1, grid2, i, j + 1);
        dfs(grid1, grid2, i, j - 1);
    }
}
