package leetcode.array;

/**
 * @program: first
 * @description: 将一维数组转变成二维数组
 * @author: panhao
 * @date: 2022-01-01 16:33
 **/
public class construct2DArray_n2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int all = original.length;
        if (all != m * n) {
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        int cur = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[cur++];
            }
        }
        return ans;
    }
}
