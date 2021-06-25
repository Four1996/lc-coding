package leetcode;

public class GenerateMatrix {
    public static  int[][] generateMatrix(int n){
        int matrix[][]=new int[n][n];
        int row=0,row1=n-1,col=0,col1=n-1,count=1;
        do {
            for (int i=col;i<=col1;i++){
                matrix[row][i]=count;
                count++;
            }
            if (count<=Math.pow(n,2)){
                row++;
                for (int j=row;j<=row1;j++){
                    matrix[j][col1]=count;
                    count++;
                }
                if (count<=Math.pow(n,2)){
                    col1--;
                    for (int i=col1;col<=i;i--){
                        matrix[row1][i]=count;
                        count++;
                    }
                    if (count<=Math.pow(n,2)){
                        row1--;
                        for (int j=row1;row<=j;j--){
                            matrix[j][col]=count;
                            count++;
                        }
                        col++;
                    }
                }
            }



        }while(count<=Math.pow(n,2));
        return matrix;
    }
    public static void main(String[] args) {
        int n=2;
        int mat[][]=generateMatrix(n);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.println(mat[i][j]);
            }
        }

    }
}
