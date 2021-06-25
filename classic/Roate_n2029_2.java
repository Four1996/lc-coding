package leetcode.classic;

/**
 * @program: first
 * @description: 旋转矩阵
 * @author: panhao
 * @date: 2021-06-22 10:12
 **/
public class Roate_n2029_2 {
    public void roate(int[][] matrix){
        int row=matrix.length,col=matrix[0].length;
        for (int i=0;i<row;i++){
            for (int j=i;j<col;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for (int i=0;i<row;i++){
            for (int j=0;j<col/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][col-1-j];
                matrix[i][col-1-j]=temp;
            }
        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new Roate_n2029_2().roate(matrix);
    }
}
