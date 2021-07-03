package leetcode.dp;

/**
 * @program: first
 * @description: 第 N 个泰波那契数
 * @author: panhao
 * @date: 2021-07-03 09:41
 **/
public class Tribonacci_n1137 {
    public int tribonacci(int n) {
        if (n<3){
            if (n==0) return 0;
            else return 1;
        }
        int[] dp=new int[n+1];
        dp[1]=1;dp[2]=1;
        for (int i=3;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
