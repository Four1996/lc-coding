package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月03日 4:43 下午
 */
public class TranslateNum_n1968 {
    public int translateNum(int num) {
        String s=" "+num;
        int[][] dp=new int[s.length()][2];
        dp[0][0]=1;
        for (int i=1;i<dp.length;i++){
            String str=s.substring(i-1,i+1);
            str=str.trim();
            int n= Integer.parseInt(str);
            String ss= String.valueOf(n);
            if (ss.length()==1&&i!=1){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
                dp[i][1]=dp[i][0];
            }else{
                if (n<26){
                    dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
                    dp[i][1]=dp[i-1][0]+dp[i-1][1];
                }
                else{
                    dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
                    dp[i][1]=dp[i][0];
                }
            }
        }
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
    }
}
