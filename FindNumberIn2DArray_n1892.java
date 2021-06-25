package leetcode;

/**
 * @author panhao
 * @date 2021年05月08日 9:41 上午
 */
public class FindNumberIn2DArray_n1892 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0) return false;
        if (matrix[0].length==0) return false;
        int row=matrix.length;
        int col=matrix[0].length;
        int left=col-1,right=0;
        while (left>=0&&right<=row-1){
            if (matrix[right][left]==target) return true;
            if (matrix[right][left]>target) --left;
            else ++right;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums={
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        System.out.println(new FindNumberIn2DArray_n1892().findNumberIn2DArray(nums,88));
    }
}
