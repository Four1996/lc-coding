package leetcode;

/**
 * @author panhao
 * @date 2021年05月08日 3:52 下午
 */
public class Fib_n1897 {
    public static int fib(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int a=0,b=1,ans=0;
        for (int i=2;i<=n;i++){
            ans=(a+b)%1000000007;
            a=b;
            b=ans;
        }
        return ans==1000000008?1:ans;
    }

    public static void main(String[] args) {
        System.out.println(fib(48));
    }
}
