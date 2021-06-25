package leetcode;

/**
 * @author panhao
 * @date 2021年04月15日 3:49 下午
 */
public class MaxProfit_n122 {
    public int maxProfit(int[] prices){
        int len=prices.length;
        if (len<2) return 0;
        int ans=0;
        for (int i=1;i<len;i++){
            int diff=prices[i]-prices[i-1];
            ans+=diff>0?diff:0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={7,1,5,3,6,4};
        MaxProfit_n122 maxProfit_n122=new MaxProfit_n122();
        System.out.println(maxProfit_n122.maxProfit(nums));
    }
}
