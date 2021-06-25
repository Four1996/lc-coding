package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix){
        int row=matrix.length;
        int col=matrix[0].length;
        int number=row*col;
        List<Integer> list=new ArrayList<Integer>(number);
        int row1=0,row2=row,col1=0,col2=col;
        do {
            for (int i=col1;i<col2;i++){
                list.add(matrix[row1][i]);
            }
            if (list.size()!=number){
                row1++;
                for (int j=row1;j<row2;j++){
                    list.add(matrix[j][col2-1]);
                }
                if (list.size()!=number){
                    col2--;
                    for (int j=col2-1;col1<=j;j--){
                        list.add(matrix[row2-1][j]);
                    }
                    if (list.size()!=number){
                        row2--;
                        for (int i=row2-1;row1<=i;i--){
                            list.add(matrix[i][col1]);
                        }
                        col1++;
                    }

                }

            }


        }while (list.size()<number);


        return list;
    }

    public static void main(String[] args) {
        int[][] a=new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        List<Integer> list=spiralOrder(a);
        System.out.println(list);
    }
}
