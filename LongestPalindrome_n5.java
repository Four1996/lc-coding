package leetcode;

import test.ProxyTest.Lenovo;

import java.beans.beancontext.BeanContext;

/**
 * @author panhao
 * @date 2021年05月17日 9:47 下午
 */
public class LongestPalindrome_n5 {
    public String longestPalindrome(String s) {
        String ans = "";
        int len = s.length();
        if (len < 0) return null;
        s = change(s);
        for (int i = 1; i < s.length()-1; i++) {
            String cur = String.valueOf(s.charAt(i));
            int pre = i - 1, post = i + 1;
            while (s.charAt(pre) == s.charAt(post)) {
                cur = s.substring(pre, post + 1);
                pre--;
                post++;
                if (pre < 0 || post == s.length()) break;
            }
            if (cur.replace("#","").length() >=ans.replace("#","").length()) ans = cur;
        }
        ans = ans.replace("#", "");

        if (ans.length() < 1) return s.substring(0, 1);
        return ans;
    }

    public String change(String s) {
        int len = s.length() * 2 - 1;
        String ans = "";
        for (int i = 0; i < len; i++) {
            if (i % 2 == 1) ans += '#';
            else ans += s.charAt(i / 2);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new LongestPalindrome_n5().longestPalindrome(s));
    }
}
