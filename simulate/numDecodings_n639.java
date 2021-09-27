package leetcode.simulate;

/**
 * @program: first
 * @description: 解码方法II
 * @author: panhao
 * @date: 2021-09-27 08:58
 **/
public class numDecodings_n639 {
    public static int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        long[] dp = new long[len];
        int mod = (int) (1e9 + 7);
        if (chars[0] == '*') {
            dp[0] = 9;
        } else if (chars[0] == '0') {
            dp[0] = 0;
        } else {
            dp[0] = 1;
        }
        for (int i = 1; i < len; i++) {
            char c = chars[i], pre = chars[i - 1];
            if (c == '*') {
                dp[i] = (dp[i - 1] * 9);
                if (pre == '*') {
                    dp[i] += (i - 2 >= 0 ? dp[i - 2] * 15 : 15);
                } else {
                    int u = pre - '0';
                    if (u == 1) {
                        dp[i] += (i - 2 >= 0 ? dp[i - 2] * 9 : 9);
                    } else if (u == 2) {

                        dp[i] += (i - 2 >= 0 ? dp[i - 2] * 6 : 6);
                    }
                }
            } else {
                int cur = c - '0';
                if (pre == '*') {
                    if (cur == 0) {
                        dp[i] += (i - 2 >= 0 ? dp[i - 2] * 2 : 2);
                    } else if (cur <= 6) {
                        dp[i] = dp[i - 1];
                        dp[i] += (i - 2 >= 0 ? dp[i - 2] * 2 : 2);
                    } else {
                        dp[i] = dp[i - 1];
                        dp[i] += (i - 2 >= 0 ? dp[i - 2] : 1);
                    }
                } else {
                    int u = pre - '0';
                    if (cur == 0) {
                        if (u == 1 || u == 2) {
                            dp[i] += (i - 2 >= 0 ? dp[i - 2] : 1);
                        }
                    } else {
                        dp[i] = dp[i - 1];
                        if (u == 1) {
                            dp[i] += (i - 2 >= 0 ? dp[i - 2] : 1);
                        } else if (u == 2 && cur <= 6) {
                            dp[i] += (i - 2 >= 0 ? dp[i - 2] : 1);
                        }
                    }
                }
            }
            dp[i] = dp[i] % mod;
        }
        return (int) dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("***"));
    }
}
