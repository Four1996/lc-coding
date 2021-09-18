package leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: first
 * @description: 有效的数独
 * @author: panhao
 * @date: 2021-08-27 10:05
 **/
public class IsValidSudoku_n36 {
    boolean[][] vis;
    int row, col;
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    boolean tag = true;

    public boolean isValidSudoku(char[][] board) {
        row = board.length;
        col = board[0].length;
        vis = new boolean[row][col];
        int[][] side = {{0, 2}, {3, 5}, {6, 8}};
        List<HashSet<Integer>> colList =new ArrayList<>();
        List<HashSet<Integer>> rowList =new ArrayList<>();
        for (int i = 0; i < row; i++) {
            colList.add(new HashSet<>());
            rowList.add(new HashSet<>());
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '0';
                    if (colList.get(j).contains(n)) {
                        return false;
                    } else {
                        colList.get(j).add(n);
                    }
                    if (rowList.get(i).contains(n)) {
                        return false;
                    } else {
                        rowList.get(i).add(n);
                    }
                }
                if (!vis[i][j]) {
                    HashSet<Integer> set = new HashSet<>();
                    int rowMax = 0, rowMin = 0;
                    int colMax = 0, colMin = 0;
                    for (int[] nums : side) {
                        if (i >= nums[0] && i <= nums[1]) {
                            rowMin = nums[0];
                            rowMax = nums[1];
                        }
                        if (j >= nums[0] && j <= nums[1]) {
                            colMin = nums[0];
                            colMax = nums[1];
                        }
                    }
                    dfs(board, i, j, rowMax, rowMin, colMin, colMax, set);
                    if (!tag) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void dfs(char[][] board, int r, int c, int rowMax, int rowMin, int colMin, int colMax, HashSet<Integer> set) {
        if (r < rowMin || r > rowMax || c < colMin || c > colMax || vis[r][c]) {
            return;
        }
        vis[r][c] = true;
        if (board[r][c] != '.') {
            int n = board[r][c] - '0';
            if (set.contains(n)) {
                tag = false;
                return;
            } else {
                set.add(n);
            }
        }
        for (int[] dir : dirs) {
            int x = dir[0] + r;
            int y = dir[1] + c;
            dfs(board, x, y, rowMax, rowMin, colMin, colMax, set);
        }
    }
}
