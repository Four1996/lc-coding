package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年05月18日 6:57 下午
 */
public class MyPow_n1920 {
    public double myPow(double x, int n) {
        if (x==0) return 0;
        long b=n;
        double ans=1;
        if (b<0){
            x=1/x;
            b=-b;
        }
        while (b!=0){
            if ((b&1)==1){
                ans*=x;
            }
            x*=x;
            b>>=1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow_n1920().myPow(3,9));
    }
}
