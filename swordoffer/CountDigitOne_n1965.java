package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月02日 10:30 下午
 */
public class CountDigitOne_n1965 {
    public int countDigitOne(int n) {
        int high=n,low=0,cur=0;
        int ans=0;
        int num=1;
        while (high!=0||cur!=0){
            cur=high%10;
            high/=10;
            if (cur==0) ans+=high*num;
            else if (cur==1) ans+=high*num+1+low;
            else ans+=(high+1)*num;
            low=cur*num+low;
            num*=10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountDigitOne_n1965().countDigitOne(12));
    }
}
