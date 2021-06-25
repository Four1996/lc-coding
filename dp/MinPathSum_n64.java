package leetcode.dp;

/**
 * @author panhao
 * @date 2021年05月31日 7:26 下午
 */
public class MinPathSum_n64 {
    public int minPathSum(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int[][] ans=new int[row+1][col+1];
        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){
                if (i==1||j==1){
                    if (i==1&&j==1) ans[i][j]=grid[i-1][j-1];
                    else if (i==1&&j!=1) ans[i][j]=ans[i][j-1]+grid[i-1][j-1];
                    else ans[i][j]=ans[i-1][j]+grid[i-1][j-1];
                }else {
                    ans[i][j]=Math.min(ans[i][j-1]+grid[i-1][j-1],ans[i-1][j]+grid[i-1][j-1]);
                }
            }
        }
        return ans[row][col];
    }

    public static void main(String[] args) {
        int[][] nums={
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new MinPathSum_n64().minPathSum(nums));
    }
}
