package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年05月18日 6:43 下午
 */
public class HammingWeight_n1919 {
    public int hammingWeight(int n) {
        int ans=0;
        int u=32;
        while (u!=0){
            if ((n&1)==1)ans++;
            n=n>>1;
            u--;
        }
        return ans;
    }
    public static void main(String[] args) {
        int n=00000000000000000000000010000000;
        System.out.println(new HammingWeight_n1919().hammingWeight(n));
    }
}
