package leetcode.strings;

/**
 * @program: first
 * @description: 反转字符串
 * @author: panhao
 * @date: 2021-08-20 09:12
 **/
public class ReverseStr_n541 {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int left = 0, right = k * 2 - 1;
        while (left < len) {
            int mid = (left + right) >> 1;
            if (mid >= len) {
                mid = len - 1;
            }
            int i = left, j = mid;
            while (i < j) {
                char c = chars[i];
                chars[i] = chars[j];
                chars[j] = c;
                i++;
                j--;
            }
            left = right + 1;
            right = right + 2 * k;
        }
        return new String(chars);
    }
}
