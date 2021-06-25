package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月03日 6:40 下午
 */
public class MaxValue_n1969 {
    public int maxValue(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int[][] dp=new int[row+1][col+1];
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                dp[i][j]=Math.max(grid[i-1][j-1]+dp[i-1][j],grid[i-1][j-1]+dp[i][j-1]);
            }
        }
        return dp[row][col];
    }

}
