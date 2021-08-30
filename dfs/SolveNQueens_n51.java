package leetcode.dfs;

import java.util.*;

/**
 * @program: first
 * @description: N皇后
 * @author: panhao
 * @date: 2021-08-25 09:58
 **/
public class SolveNQueens_n51 {
    List<List<String>> ans;
    Set<Integer> col;
    Set<Integer> leftDiagonal;
    Set<Integer> rightDiagonal;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        if (n == 1) {
            ans.add(new ArrayList<>(Collections.singletonList("Q")));
            return ans;
        }
        if (1 < n && n < 4) {
            return new ArrayList<>();
        }
        col = new HashSet<>();
        leftDiagonal = new HashSet<>();
        rightDiagonal = new HashSet<>();
        char[][] grid = new char[n][n];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], '.');
        }
        dfs(grid, 0, n);
        return ans;
    }

    public void dfs(char[][] grid, int row, int n) {
        if (row == n) {
            ans.add(charToList(grid));
            return;
        }
        for (int i = 0; i < grid[row].length; i++) {
            if (!isValid(grid, row, i)) {
                continue;
            }
            col.add(i);
            leftDiagonal.add(row - i);
            rightDiagonal.add(row + i);
            grid[row][i] = 'Q';
            dfs(grid, row + 1, n);
            grid[row][i] = '.';
            rightDiagonal.remove(row + i);
            leftDiagonal.remove(row - i);
            col.remove(i);
        }
    }

    public boolean isValid(char[][] grid, int row, int i) {
        return !leftDiagonal.contains(row - i) && !rightDiagonal.contains(row + i) && !col.contains(i) && grid[row][i] != 'Q';
    }

    public List<String> charToList(char[][] grid) {
        List<String> res = new ArrayList<>();
        for (char[] chars : grid) {
            res.add(new String(chars));
        }
        return res;
    }

    public static void main(String[] args) {
        SolveNQueens_n51 s = new SolveNQueens_n51();
        System.out.println(s.solveNQueens(4));
    }
}
