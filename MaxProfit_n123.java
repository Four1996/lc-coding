package leetcode;

/**
 * @author panhao
 * @date 2021年04月15日 3:49 下午
 */
public class MaxProfit_n123 {
    public int maxProfit(int[] prices){
        int len=prices.length;
        if (len<2) return 0;
        int[][] dp=new int[len][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i=1;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }

    public static void main(String[] args) {
        int[] nums={7,1,5,3,6,4};
        MaxProfit_n123 maxProfit_n122=new MaxProfit_n123();
        System.out.println(maxProfit_n122.maxProfit(nums));
    }
}
