package leetcode.dp;

/**
 * @program: first
 * @description: 不含连续1的非负整数
 * @author: panhao
 * @date: 2021-09-11 09:55
 **/
public class findIntegers_n600 {
    static int N = 50;
    // f[i][j] 为考虑二进制长度为 i，而且最高位为 j（0 or 1）时的合法数个数
    static int[][] f = new int[N][2];
    static {
        f[1][0] = 1; f[1][1] = 2;
        for (int i = 1; i < N - 1; i++) {
            f[i + 1][0] = f[i][1];
            f[i + 1][1] = f[i][0] + f[i][1];
        }
    }
    int getLen(int n) {
        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                return i;
            }
        }
        return 0;
    }
    public int findIntegers(int n) {
        int len = getLen(n);
        int ans = 0, prev = 0;
        for (int i = len; i >= 0; i--) {
            // 当前位是 0 还是 1
            int cur = ((n >> i) & 1);
            // 如果当前位是 1，那么填 0 的话，后面随便填都符合，将方案数累加
            if (cur == 1) {
                ans += f[i + 1][0];
            }
            // 出现连续位为 1，分支结束，方案数被计算完
            if (prev == 1 && cur == 1) {
                break;
            }
            prev = cur;
            if (i == 0) {
                ans++;
            }
        }
        return ans;
    }

}
