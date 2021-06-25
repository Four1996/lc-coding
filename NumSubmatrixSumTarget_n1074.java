package leetcode;

/**
 * @author panhao
 * @date 2021年05月29日 9:15 上午
 */
public class NumSubmatrixSumTarget_n1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans=0;
        int row=matrix.length,col=matrix[0].length;
        int [][] sum=new int[row+1][col+1];
        for (int i=1;i<row+1;i++){
            for (int j=1;j<col+1;j++){
                sum[i][j]=sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+matrix[i-1][j-1];
            }
        }
        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){
                for (int p=1;p<=i;p++){
                    for (int q=1;q<=j;q++){
                        if (sum[i][j]-sum[p-1][j]-sum[i][q-1]+sum[p-1][q-1]==target) ans++;
                    }
                }
            }
        }
        return ans;
    }

}
