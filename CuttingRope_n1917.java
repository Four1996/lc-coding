package leetcode;

/**
 * @author panhao
 * @date 2021年05月18日 11:05 上午
 */
public class CuttingRope_n1917 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int max_product = 0;
            for (int j = 1; j < i; j++) {
                max_product =Math.max(max_product,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i]= max_product;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new CuttingRope_n1917().cuttingRope(120));
    }
}
