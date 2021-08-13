package leetcode.math;

/**
 * @program: first
 * @description: 数字1的个数
 * @author: panhao
 * @date: 2021-08-13 09:36
 **/
public class CountDigitOne_n233 {
    public int countDigitOne(int n) {
        int high=n,low=0,cur=0;
        int ans=0;
        int num=1;// 底数 10^i
        while (high!=0||cur!=0){
            cur=high%10;
            high/=10;
            if (cur==0) {
                ans+=high*num;
            } else if (cur==1) {
                ans+=high*num+1+low;
            } else {
                ans+=(high+1)*num;
            }
            low=cur*num+low;
            num*=10;
        }
        return ans;
    }
}
