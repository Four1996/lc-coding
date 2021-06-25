package leetcode;

/**
 * @author panhao
 * @date 2021年04月15日 2:24 下午
 */
public class ClimbStairs_n70 {
    public int climbStairs(int n){
        if (n==1) return 1;
        int[] dp=new int[n+1];
        dp[0]=0;dp[1]=1;dp[2]=2;
        for (int i=3;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        ClimbStairs_n70 climbStairs_n70=new ClimbStairs_n70();
        System.out.println(climbStairs_n70.climbStairs(5));
    }
}
