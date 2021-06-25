package leetcode.classic;

/**
 * @program: first
 * @description: 旋转矩阵
 * @author: panhao
 * @date: 2021-06-22 10:12
 **/
public class Roate_n2029 {
    public void roate(int[][] matrix){
        int row=matrix.length,col=matrix[0].length;
        int[][] ans=new int[row][col];
        for (int i1=0,j2=col-1;i1<row&&j2>=0;i1++,j2--){
            for (int j1=0,i2=0;j1<col&&i2<row;j1++,i2++){
                ans[i2][j2]=matrix[i1][j1];
            }
        }
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                matrix[i][j]=ans[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new Roate_n2029().roate(matrix);
    }
}
