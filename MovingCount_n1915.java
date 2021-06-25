package leetcode;

import java.security.PublicKey;

/**
 * @author panhao
 * @date 2021年05月17日 10:12 上午
 */
public class MovingCount_n1915 {
    int ans=0;
    int[][] mn;
    public int movingCount(int m, int n, int k) {
        mn=new int[m][n];
        dfs(m,n,0,0,k);
        return ans;
    }
    boolean judge(int i,int j,int k){
        mn[i][j]=-1;
        int sum=0;
        int row=i,col=j;
        while (row!=0){
            sum+=row%10;
            row/=10;
        }
        while (col!=0){
            sum+=col%10;
            col/=10;
        }
        if (sum<=k) return true;
        return false;
    }
    void dfs(int m,int n,int i,int j,int k){
        if (i>=m||j>=n||i<0||j<0) return;
        else if (mn[i][j]==-1) return;
        if (judge(i,j,k)){
            ans++;
            dfs(m,n,i+1,j,k);
            dfs(m,n,i,j+1,k);
            dfs(m,n,i-1,j,k);
            dfs(m,n,i,j-1,k);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount_n1915().movingCount(16,8,4));
    }
}
