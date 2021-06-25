package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月03日 4:43 下午
 */
public class TranslateNum_n1968_2 {
    public int translateNum(int num) {
        String s=" "+num;
        int[] dp=new int[s.length()];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<s.length();i++){
            String str=s.substring(i-1,i+1);
            if (str.compareTo("10")>=0&&str.compareTo("26")<0){
                dp[i]=dp[i-1]+dp[i-2];

            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}
