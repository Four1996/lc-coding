package leetcode;

/**
 * @author panhao
 * @date 2021年04月15日 2:40 下午
 */
public class MaxProfit_n121 {
    public int maxProfit(int[] prices){
        int len=prices.length;
        if (len==1) return 0;
        int max=0,pre=0,cur;
        for (int i=1;i<len;i++){
            int diff=prices[i]-prices[i-1];
            cur=Math.max(pre+diff,0);
            max=Math.max(max,cur);
            pre=cur;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProfit_n121 maxProfit_n121=new MaxProfit_n121();
        int[] nums={3,2,6,5,0,3};
        System.out.println(maxProfit_n121.maxProfit(nums));
    }
}
