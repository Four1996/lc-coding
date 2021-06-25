package leetcode.dp;

/**
 * @author panhao
 * @date 2021年05月31日 7:10 下午
 */
public class UniquePathsWithObstacles_n63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length,col=obstacleGrid[0].length;
        int [][] ans=new int[row+1][col+1];
        for (int i=1;i<=row;i++){
            for (int j=1;j<=col;j++){
                if (obstacleGrid[i-1][j-1]==1) ans[i][j]=0;
                else{
                    if (i==1&&j==1) ans[i][j]=1;
                    else{
                        ans[i][j]=ans[i][j-1]+ans[i-1][j];
                    }
                }
            }
        }
        return ans[row][col];
    }
}
