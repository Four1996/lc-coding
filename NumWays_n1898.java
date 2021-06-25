package leetcode;

/**
 * @author panhao
 * @date 2021年05月08日 4:16 下午
 */
public class NumWays_n1898 {
    public static int numWays(int n) {

        if (n<=1) return 1;
        if (n==2) return 2;
        int a=1,b=2,ans=0;
        for (int i=3;i<=n;++i){
            ans=(a+b)%1000000007;
            a=b;
            b=ans;
        }
        return ans==1000000008?1:ans;
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
