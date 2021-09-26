package leetcode.prefix_sum;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-26 10:36
 **/
public class gridGame_n5882 {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long[][] preSum=new long[2][n+1];
        for (int i = 1; i <=n ; i++) {
            preSum[0][i]=preSum[0][i-1]+grid[0][i-1];
            preSum[1][i]=preSum[1][i-1]+grid[1][i-1];
        }
        long ans=Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            ans=Math.min(Math.max(preSum[1][i-1],preSum[0][n]-preSum[0][i]),ans);
        }
        return ans;
    }

    // void dfs(int[][] grid, int r, int c,int temp,List<int[]> list) {
    //     if (r<0||r==grid.length||c<0||c==grid[0].length||vis[r][c]){
    //         return;
    //     }
    //     list.add(new int[]{r, c});
    //     vis[r][c]=true;
    //
    //     if (r == 1 && c == n - 1) {
    //         if (temp+grid[r][c]>sum){
    //             sum=temp+grid[r][c];
    //             path=new ArrayList<>(list);
    //         }
    //         list.remove(list.size()-1);
    //         vis[r][c]=false;
    //         return;
    //     }
    //     for (int[] dir : dirs) {
    //         int x=dir[0]+r;
    //         int y=dir[1]+c;
    //         dfs(grid,x,y,temp+grid[r][c],list);
    //
    //     }
    //     vis[r][c]=false;
    //     list.remove(list.size()-1);
    // }

    public static void main(String[] args) {
        gridGame_n5882 g=new gridGame_n5882();
        int[][] nums={{2,5,4},{1,5,1}};
        System.out.println(g.gridGame(nums));
    }
}
