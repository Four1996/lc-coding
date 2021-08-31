package leetcode.dp;

/**
 * @program: first
 * @description: 回文子字符串的个数
 * @author: panhao
 * @date: 2021-08-30 21:48
 **/
public class CountSubstrings_n2124 {
    public static int countSubstrings(String s) {
        int len = s.length();
        char[] chars = new char[len * 2 - 1];
        int ans = 0;
        for (int i = 0, j = 0; i < chars.length && j < len; j++) {
            chars[i++] = s.charAt(j);
            if (i < chars.length) {
                chars[i++] = '*';
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '*') {
                ans++;
            }
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                if (chars[left]!='*'){
                    ans++;
                }
                left--;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="abc";
        System.out.println(countSubstrings(s));
    }
}
