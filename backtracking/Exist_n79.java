package leetcode.backtracking;

/**
 * @program: first
 * @description: 单词搜索
 * @author: panhao
 * @date: 2021-07-16 14:39
 **/
public class Exist_n79 {

    boolean[][] vis;
    int row, col;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        vis = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && !vis[i][j]) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, String word, int cur) {
        if (r >= row || c >= col || r < 0 || c < 0 || vis[r][c] || board[r][c] != word.charAt(cur)) {
            return false;
        }
        vis[r][c] = true;
        if (cur == word.length() - 1) return true;
        boolean res = dfs(board, r + 1, c, word, cur + 1) ||
                dfs(board, r, c + 1, word, cur + 1) ||
                dfs(board, r - 1, c, word, cur + 1) ||
                dfs(board, r, c - 1, word, cur + 1);
        vis[r][c] = false;
        return res;
    }
}
