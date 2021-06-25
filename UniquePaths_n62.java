package leetcode;

/**
 * @author panhao
 * @date 2021年05月31日 6:56 下午
 */
public class UniquePaths_n62 {
    public int uniquePaths(int m, int n) {
        int[][] ans=new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (i==1&&j==1) ans[i][j]=1;
                else ans[i][j]=ans[i][j-1]+ans[i-1][j];
            }
        }
        return ans[m][n];
    }
}
