package leetcode.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: first
 * @description: 含有所有字符的最短字符串
 * @author: panhao
 * @date: 2021-08-31 10:23
 **/
public class MinWindow_n2121_2 {
    public static String minWindow(String s, String t) {
        int l1 = s.length();
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> counter = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (char tChar : tChars) {
            tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
        }
        int minL = -1, minR = -1, minWindow = Integer.MAX_VALUE;
        int left = 0, right = -1;
        while (right < l1) {
            while (left <= right && !tMap.containsKey(sChars[left])) {
                left++;
            }
            right++;
            if (right < l1 && tMap.containsKey(sChars[right])) {
                counter.put(sChars[right], counter.getOrDefault(sChars[right], 0) + 1);
            }
            while (left <= right && check(counter, tMap)) {
                if (right - left + 1 < minWindow) {
                    minWindow = right - left + 1;
                    minL = left;
                    minR = left + minWindow;
                }
                if (tMap.containsKey(sChars[left])) {
                    counter.put(sChars[left], counter.getOrDefault(sChars[left], 0) - 1);
                }
                left++;
            }
        }
        return minL == -1 ? "" : s.substring(minL, minR);
    }

    private static boolean check(HashMap<Character, Integer> counter, HashMap<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (counter.containsKey(key)) {
                if (counter.get(key) < value) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
