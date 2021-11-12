package leetcode.dp;

/**
 * @program: first
 * @description: 猜数字大小
 * @author: panhao
 * @date: 2021-11-12 22:01
 **/
public class getMoneyAmount_n375 {
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 10][n + 10];
        for (int len = 2; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                f[l][r] = 0x3f3f3f3f;
                for (int x = l; x <= r; x++) {
                    int cur = Math.max(f[l][x - 1], f[x + 1][r]) + x;
                    f[l][r] = Math.min(f[l][r], cur);
                }
            }
        }
        return f[1][n];
    }
}
