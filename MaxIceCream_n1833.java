package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description: 雪糕的最大数量
 * @author: panhao
 * @date: 2021-07-02 09:14
 **/
public class MaxIceCream_n1833 {
    public int maxIceCream(int[] costs, int coins) {
        int len=costs.length;
        Arrays.sort(costs);
        int ans=0;
        for (int i=0;i<len;i++){
            if (coins>=costs[i]){
                ans++;
                coins-=costs[i];
            }else{
                break;
            }
        }
        return ans;
    }
}
