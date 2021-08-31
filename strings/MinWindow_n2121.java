package leetcode.strings;

import java.util.HashMap;

/**
 * @program: first
 * @description: 含有所有字符的最短字符串
 * @author: panhao
 * @date: 2021-08-31 10:23
 **/
public class MinWindow_n2121 {
    // 暴力超时了。。
    public static String minWindow(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (char tChar : tChars) {
            tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
        }
        int window = l2;
        while (window <= l1) {
            int left = 0, right = left + window - 1;
            while (right < l1) {
                sMap = new HashMap<>(tMap);
                for (int i = left; i <= right; i++) {
                    if (sMap.containsKey(sChars[i])) {
                        int count = sMap.get(sChars[i]);
                        count--;
                        if (count <= 0) {
                            sMap.remove(sChars[i]);
                        }else{
                            sMap.put(sChars[i], count);
                        }
                    }
                }
                if (sMap.isEmpty()) {
                    return s.substring(left, right + 1);
                }
                left++;
                right = left + window - 1;
            }
            window++;
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        System.out.println(minWindow(s, t));
    }
}
