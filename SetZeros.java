package leetcode;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetZeros {
    public static void setZeros(int [][] matrix){
//        HashMap<Integer,Integer> hm=new HashMap<>();
//        for (int i=0;i<matrix.length;i++){
//            for (int j=0;j<matrix[0].length;j++){
//                if (matrix[i][j]==0){
//                    hm.put(i,j);
//                }
//            }
//        }
//
//        for (int i: hm.keySet()){
//            Arrays.fill(matrix[i],0);
//        }
//        for( int j:hm.values()){
//            for (int i=0;i<matrix.length;i++){
//                matrix[i][j]=0;
//            }
//
//        }
//        for (int i=0;i< matrix.length;i++){
//            for (int j=0;j<matrix[0].length;j++){
//                System.out.println(matrix[i][j]);
//            }
//        }
//------------------------------------------------------------------------
//        int row=matrix.length,col=matrix[0].length;
//        boolean [] x=new boolean[row];
//        boolean [] y=new boolean[col];
//        for (int i=0;i< row;i++){
//            for (int j=0;j<col;j++){
//                if (matrix[i][j]==0){
//                    x[i]=y[j]=true;
//                }
//            }
//        }
//        for (int i=0;i< row;i++){
//            for (int j=0;j<col;j++){
//                if (x[i]||y[j]){
//                    matrix[i][j]=0;
//                }
//            }
//        }
// ------------------------------------------------------------------------
        boolean r0=false,c0=false;
        for (int i=0;i< matrix.length;i++){
            if (matrix[i][0]==0){
                r0=true;
            }
        }
        for (int j=0;j< matrix[0].length;j++){
            if (matrix[0][j]==0){
                c0=true;
            }
        }
        for (int i=1;i< matrix.length;i++){
            for (int j=1;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    matrix[i][0]= matrix[0][j]=0;
                }
            }
        }
        for (int i=1;i<matrix.length;i++){
            if (matrix[i][0]==0){
                Arrays.fill(matrix[i],0);
            }
        }
        for (int j=1;j<matrix[0].length;j++){
            if (matrix[0][j]==0){
                Arrays.fill(matrix[j],0);
            }
        }
        if (r0){
            for (int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        if (c0){
            Arrays.fill(matrix[0],0);
        }
    }
    public static void main(String[] args) {
        int [][] test={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeros(test);
    }
}
