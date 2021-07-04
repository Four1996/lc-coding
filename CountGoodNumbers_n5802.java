package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-04 10:40
 **/
public class CountGoodNumbers_n5802 {
    public static int countGoodNumbers(long n) {
        long odd,even;
        if (n%2==0){
            odd=n/2;
            even=n-odd;
        }else{
            odd=n/2+1;
            even=n-odd;
        }
        long ans=1;
        long base5=5,base4=4;
        while (odd>0){
            if (odd%2==1){
                ans= ((ans*base5)%(1000000007));
            }
            odd=odd/2;
            base5= ((base5*base5)%(1000000007));
        }
        while (even>0){
            if (even%2==1){
                ans= ((ans*base4)%(1000000007));
            }
            even=even/2;
            base4= ((base4*base4)%(1000000007));
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(32));
    }
}
