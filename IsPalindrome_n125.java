package leetcode;

import java.util.Locale;

/**
 * @author panhao
 * @date 2021年05月04日 5:15 下午
 */
public class IsPalindrome_n125 {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.trim();
        int i = 0, j = s.length() - 1;
        for (; i < s.length() && j >= 0; ) {
            while ((s.charAt(i) < 'a' || s.charAt(i) > 'z')&&(s.charAt(i)<'0'||s.charAt(i)>'9')) {
                ++i;
                if (i==s.length()) break;
            }
            if (i==s.length()) break;
            while ((s.charAt(j) < 'a' || s.charAt(j) > 'z')&&(s.charAt(j)<'0'||s.charAt(j)>'9')) {
                --j;
                if (j==-1) return true;
            }
            if (j==-1) return true;
            if (s.charAt(i) != s.charAt(j)) return false;
            ++i;
            --j;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}
