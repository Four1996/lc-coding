package leetcode;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author panhao
 * @date 2021年05月19日 8:57 上午
 */
public class KthLargestValue_n1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int row=matrix.length,col=matrix[0].length;
        int[][] rowPre=new int[row][col+1];
        Integer[] nums=new Integer[row*col];
        for (int i=0;i<row;i++){
            for (int j=1;j<=col;j++){
                rowPre[i][j]=matrix[i][j-1]^rowPre[i][j-1];
            }
        }
        int[][] preXor=new int[row+1][col];
        int u=0;
        for (int i=1;i<=row;i++){
            for (int j=0;j<col;j++){
                preXor[i][j]=preXor[i-1][j]^rowPre[i-1][j+1];
                nums[u]=preXor[i][j];
                u++;
            }
        }
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        return nums[k-1];
    }

    public static void main(String[] args) {
        int[][] nums={
                {5,2},
                {1,6}
        };
        System.out.println(new KthLargestValue_n1738().kthLargestValue(nums,1));
    }
}
