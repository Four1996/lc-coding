package leetcode.swordoffer;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月19日 7:13 下午
 */
public class SpiralOrder_n1932 {
    public static int[] spiralOrder(int[][] matrix) {

        if (matrix==null) return new int[0];
        int row=matrix.length;
        if (row==0) return new int[0];
        int col=matrix[0].length;
        int max=row*col;
        int[] ans=new int[max];
        int count=0,top=0,bow=row-1,left=0,right=col-1;
        while (count<max){
            for (int i=top,j=left;j<=right;j++) ans[count++]=matrix[i][j];
            if (count==max) break;
            top++;
            for (int i=top,j=right;i<=bow;i++)ans[count++]=matrix[i][j];
            if (count==max) break;
            right--;
            for (int i=bow,j=right;j>=left;j--) ans[count++]=matrix[i][j];
            if (count==max)break;
            bow--;
            for (int i=bow,j=left;i>=top;i--) ans[count++]=matrix[i][j];
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums={
        };
        spiralOrder(nums);
    }
}
