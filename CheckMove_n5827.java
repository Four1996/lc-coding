package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-07 22:49
 **/
public class CheckMove_n5827 {
    int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    char color;
    int change_r, change_c;
    int row, col;

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        row = board.length;
        col = board[0].length;
        this.color = color;
        change_r = rMove;
        change_c = cMove;
        for (int[] dir : direction) {
            int x = dir[0] + change_r;
            int y = dir[1] + change_c;
            if (dfs(board, x, y, 1, dir)) return true;
        }
        return false;
    }

    boolean dfs(char[][] board, int r_idx, int c_idx, int distance, int[] dir) {
        if (r_idx < 0 || r_idx >= row || c_idx < 0 || c_idx >= col ) return false;
        if (board[r_idx][c_idx] == '.') return false;
        if (distance == 1 && board[r_idx][c_idx] == color) return false;
        if (distance > 1 && board[r_idx][c_idx] == color) return true;
        else {
            return dfs(board, r_idx + dir[0], c_idx + dir[1], distance + 1, dir);
        }
    }
}
