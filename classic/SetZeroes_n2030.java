package leetcode.classic;

/**
 * @program: first
 * @description: 0矩阵
 * @author: panhao
 * @date: 2021-06-22 16:44
 **/
public class SetZeroes_n2030 {


    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] r=new boolean[row];
        boolean[] c=new boolean[col];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (matrix[i][j]==0){
                    r[i]=true;
                    c[j]=true;
                }
            }
        }
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (r[i]||c[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        new SetZeroes_n2030().setZeroes(matrix);

    }
}
