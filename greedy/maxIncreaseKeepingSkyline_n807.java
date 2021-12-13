package leetcode.greedy;

/**
 * @program: first
 * @description: 保持城市天际线
 * @author: panhao
 * @date: 2021-12-13 22:35
 **/
public class maxIncreaseKeepingSkyline_n807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] maxRow = new int[row];
        int[] maxCol = new int[col];
        for (int i = 0; i < row; i++) {
            int maxR = 0;
            int maxC = 0;
            for (int j = 0; j < col; j++) {
                maxR = Math.max(grid[i][j], maxR);
            }
            maxRow[i] = maxR;
            for (int j = 0; j < col; j++) {
                maxC = Math.max(grid[j][i], maxC);
            }
            maxCol[i] = maxC;
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int diff = Math.min(maxRow[i], maxCol[j]) - grid[i][j];
                ans += diff;
            }
        }
        return ans;
    }
}
