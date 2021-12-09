package leetcode.simulate;

/**
 * @program: first
 * @description: 有效的井字游戏
 * @author: panhao
 * @date: 2021-12-09 21:53
 **/
public class validTicTacToe_n794 {
    public boolean validTicTacToe(String[] board) {
        char[][] cs = new char[3][3];
        int x = 0, o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') x++;
                else if (c == 'O') o++;
                cs[i][j] = c;
            }
        }
        boolean a = check(cs, 'X'), b = check(cs, 'O');
        if (o > x || x - o > 1) return false;
        if (a && x <= o) return false;
        if (b && o != x) return false;
        if (a && b) return false;
        return true;
    }
    boolean check(char[][] cs, char c) {
        for (int i = 0; i < 3; i++) {
            if (cs[i][0] == c && cs[i][1] == c && cs[i][2] == c) return true;
            if (cs[0][i] == c && cs[1][i] == c && cs[2][i] == c) return true;
        }
        boolean a = true, b = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) a &= cs[i][j] == c;
                if (i + j == 2) b &= cs[i][j] == c;
            }
        }
        return a || b;
    }
}
