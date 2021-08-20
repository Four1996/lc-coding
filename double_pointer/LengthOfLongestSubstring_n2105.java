package leetcode.double_pointer;

import java.util.HashMap;

/**
 * @program: first
 * @description: 不含重复字符的最长子字符串
 * @author: panhao
 * @date: 2021-08-20 11:00
 **/
public class LengthOfLongestSubstring_n2105 {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int left = 0, right = 0;
        int ans = 0;
        while (right < len) {
            if (map.containsKey(c[right])) {
                int idx = map.get(c[right]);
                if (idx>=left){
                    left = idx + 1;
                }
            }
            map.put(c[right], right);
            right++;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s="abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
