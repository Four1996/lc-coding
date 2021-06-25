package leetcode;

/**
 * @author panhao
 * @date 2021年04月22日 9:51 上午
 */
public class NumMatrix_n304 {
    int[][] sum;
    public NumMatrix_n304(int[][] matrix) {
        int row=matrix.length,col=matrix[0].length;
        sum=new int[row][col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (i==0&&j==0) sum[i][j]=matrix[i][j];
                if (i==0&&j!=0) sum[i][j]=sum[i][j-1]+matrix[i][j];
                if (i!=0&&j==0) sum[i][j]=sum[i-1][j]+matrix[i][j];
                if (i!=0&&j!=0) sum[i][j]=sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row2==0&&col2==0) return sum[row2][col2];
        if (col1==0&&row1==0) return sum[row2][col2];
        else if(row1!=0&&col1==0) return sum[row2][col2]-sum[row1-1][col2];
        else if(row1==0&&col1!=0) return sum[row2][col2]-sum[row2][col1-1];
        return sum[row2][col2]-sum[row2][col1-1]-sum[row1-1][col2]+sum[row1-1][col1-1];
    }

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */
}
