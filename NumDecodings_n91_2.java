package leetcode;

/**
 * @author panhao
 * @date 2021年04月21日 9:13 上午
 */
public class NumDecodings_n91_2 {
    public int numDecodings(String s){
        int len = s.length();
        if (len == 0) return 0;
        // dp[i] 以 s[i] 结尾的前缀子串有多少种解码方法
        // dp[i] = dp[i - 1] * 1 if s[i] != '0'
        // dp[i] += dp[i - 2] * 1 if  10 <= int(s[i - 1..i]) <= 26
        int[] dp = new int[len];
//        char[] charArray = s.toCharArray();
        if (s.charAt(0) == '0') return 0;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != '0') dp[i] = dp[i - 1];
            int u =Integer.valueOf(s.substring(i-1,i+1));
            if (u >= 10 && u <= 26) {
                if (i == 1) dp[i]++;
                else dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        NumDecodings_n91_2 numDecodings_n91=new NumDecodings_n91_2();
        String s="2611055971756562";
        System.out.println(numDecodings_n91.numDecodings(s));
    }
}
