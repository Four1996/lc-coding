package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月05日 10:28 下午
 */
public class MaxProfit_n69 {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int min=Integer.MAX_VALUE;int max=0;
        for (int i=0;i<len;i++){
            min=Math.min(prices[i],min);
            max=Math.max(prices[i]-min,max);
        }
        return max;
    }
}
