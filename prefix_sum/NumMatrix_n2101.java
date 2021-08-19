package leetcode.prefix_sum;

/**
 * @program: first
 * @description: 二维子矩阵的和
 * @author: panhao
 * @date: 2021-08-19 09:10
 **/
public class NumMatrix_n2101 {
    int row, col;
    int[][] preSum;

    public NumMatrix_n2101(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        preSum = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
}
