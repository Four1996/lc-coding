package leetcode;

import java.util.HashSet;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-12 11:15
 **/
public class maxProduct_n5869 {
    int ans = 0;

    public int maxProduct(String s) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        dfs(s, str1, str2, 0);
        return ans;
    }

    public void dfs(String s, StringBuilder str1, StringBuilder str2, int index) {
        if (isPalindromic(str1) && isPalindromic(str2)) {
            ans = Math.max(str1.length() * str2.length(), ans);
        }
        if (index == s.length()) {
            return;
        }
        dfs(s, str1.append(s.charAt(index)), str2, index + 1);
        str1.deleteCharAt(str1.length() - 1);
        dfs(s, str1, str2.append(s.charAt(index)), index + 1);
        str2.deleteCharAt(str2.length() - 1);
        dfs(s, str1, str2, index + 1);
    }

    public boolean isPalindromic(StringBuilder sb) {
        char[] array = sb.toString().toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
