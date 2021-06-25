package leetcode;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix,int target){
        boolean res=false;
        int row=matrix.length,col=matrix[0].length;
        for(int i=0;i<row;i++){
            if(target<matrix[i][0]){ return false;}
            if (target>=matrix[i][0]&&target<=matrix[i][col-1]){
                for (int j=0;j<col;j++){
                    if (matrix[i][j]==target) return true;
                }
            }
        }
        return res;
    }
}
