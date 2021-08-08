package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-08 10:30
 **/
public class IsPrefixString_n5838 {
    public boolean isPrefixString(String s, String[] words) {
        int i = 0;
        for (String word : words) {
            if (i >= s.length()) break;
            if ((s.length()-i)<word.length()) return false;
            char[] chars = word.toCharArray();
            for (int j = 0; j < chars.length && i < s.length(); i++, j++) {
                if (s.charAt(i) != chars[j]) return false;
            }
        }
        return i >= s.length();
    }
}
