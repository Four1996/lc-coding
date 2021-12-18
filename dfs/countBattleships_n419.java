package leetcode.dfs;

/**
 * @program: first
 * @description: 甲板上的战舰
 * @author: panhao
 * @date: 2021-12-18 21:34
 **/
public class countBattleships_n419 {
    int row, col;
    boolean[][] vis;
    int[][] dirs = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};

    public int countBattleships(char[][] board) {
        row = board.length;
        col = board[0].length;
        vis = new boolean[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X' && !vis[i][j]) {
                    dfs(board, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] == '.' || vis[r][c]) {
            return;
        }
        vis[r][c] = true;
        for (int[] dir : dirs) {
            int x = dir[0];
            int y = dir[1];
            dfs(board, r + x, c + y);
        }
    }
}
