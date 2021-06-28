package leetcode;

/**
 * @program: first
 * @description: 循环轮转矩阵
 * @author: panhao
 * @date: 2021-06-27 20:39
 **/
public class RotateGrid_n5798_2 {


    public int[][] rotateGrid(int[][] a, int K) {
        int n = a.length, m = a[0].length;
        for(int i=0,j=n-1,k=0,l=m-1; i<=j&&k<=l; i++,j--,k++,l--)
            for(int t=0, tn=K%((n+m-2-i*4)<<1); t<tn; t++){
                int temp = a[i][k];
                for(int s = k+1;s <= l;s++) a[i][s-1] = a[i][s];
                for(int s = i+1;s <= j;s++) a[s-1][l] = a[s][l];
                for(int s = l-1;s >= k;s--) a[j][s+1] = a[j][s];
                for(int s = j-1;s >= i+1;s--) a[s+1][k] = a[s][k];
                a[i+1][k] = temp;
            }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5};
        int[][] grid={
                {40,10},
                {30,20}
        };
        System.out.println(new RotateGrid_n5798_2().rotateGrid(grid, 1));
    }
}
