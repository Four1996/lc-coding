package leetcode.dp;

/**
 * @program: first
 * @description: 使用最小花费爬楼梯
 * @author: panhao
 * @date: 2021-07-04 10:06
 **/
public class MinCostClimbingStairs_n746 {
    public static int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        if (len<2) return 0;
        int[] dp=new int[len+1];
        dp[0]=0;
        dp[1]=0;
        for (int i=2;i<dp.length;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int[] cost={1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
