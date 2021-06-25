package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月24日 9:02 上午
 */
public class StrangePrinter_n {
    public static int strangePrinter(String s) {

        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minn;
                }
            }
        }
        return f[0][n - 1];
    }

    public static void main(String[] args) {
        String s="tbgtgb";
        System.out.println(strangePrinter(s));
    }
}
