package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月05日 8:39 下午
 */
public class DicesProbability_n1988 {
    public static double[] dicesProbability(int n) {
        int[][] dp=new int[n+1][6*n+1];
        for (int i=1;i<=6;i++){
            dp[1][i]=1;
        }
//        第一层代表第几个筛子
        for (int i=2;i<=n;i++){
//            第二层代表目前能筛出来的点数
            for (int j=i;j<=6*i;j++){
//                第三层代表第i次与第i-1次的点数差范围
                for (int k=1;k<=6&&k<=j;k++){
                    dp[i][j]+=dp[i-1][j-k];
                }
            }
        }
        double all=Math.pow(6,n)*1.0;
        double[] ans=new double[6*n-n+1];
        for (int i=n;i<=6*n;i++){
            ans[i-n]=dp[n][i]/all;
        }
        return ans;
    }

    public static void main(String[] args) {
        for (double v : dicesProbability(2)) {
            System.out.println(v);
        }
    }
}
