package leetcode.dfs;

/**
 * @program: first
 * @description: 出界的路径数(借助缓存坐标和结果，进行剪枝)
 * @author: panhao
 * @date: 2021-08-15 14:22
 **/
public class FindPaths_n576 {
    int mod=(int)1e9+7;
    int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
    // 缓存，存储相同坐标相同步数的情况下，的结果
    int[][][] cached;
    int m,n;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cached = new int[maxMove + 1][m][n];
        this.m = m;
        this.n = n;
        return dfs(startRow, startColumn, 0, maxMove) % mod;
    }
    public int dfs(int r, int c, int step, int maxMove) {
        if (step <= maxMove && (r < 0 || c < 0 || r > m - 1 || c > n - 1)) {
            return 1;
        }
        if (step > maxMove || ((m -r)  > (maxMove - step)&& (n - c) > (maxMove - step) && r > (maxMove - step) && c > (maxMove - step))) {
            return 0;
        }
        if (cached[step][r][c] == 0) {
            for (int[] dir : dirs) {
                int nextRow = r + dir[0];
                int nextCol = c + dir[1];
                cached[step][r][c] = (cached[step][r][c] + dfs(nextRow, nextCol, step + 1, maxMove)) % mod;
            }
        }
        return cached[step][r][c];
    }

    public static void main(String[] args) {
        FindPaths_n576 f = new FindPaths_n576();
        System.out.println(f.findPaths(1, 3, 3, 0, 1));
    }
}
