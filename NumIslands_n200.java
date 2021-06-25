package leetcode;

/**
 * @program: first
 * @description: 岛屿数量
 * @author: panhao
 * @date: 2021-06-20 14:53
 **/
public class NumIslands_n200 {
    boolean[][] vis;
    int row, col;

    public int numIslands(char[][] grid) {
        int ans = 0;
        row = grid.length;
        col = grid[0].length;
        vis = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && vis[i][j] == false) {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || j >= col || i >= row || vis[i][j] == true || grid[i][j] == '0') return;
        vis[i][j] = true;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        NumIslands_n200 n = new NumIslands_n200();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(n.numIslands(grid));
    }
}
