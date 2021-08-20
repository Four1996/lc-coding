package leetcode.double_pointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: first
 * @description: 字符串中的所有变位词
 * @author: panhao
 * @date: 2021-08-20 09:20
 **/
public class FindAnagrams_n2104 {
    public List<Integer> findAnagrams(String s, String p) {
        int l1 = s.length(), l2 = p.length();
        if (l1 < l2) {
            return new ArrayList<>();
        }
        char[] charsP = p.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : charsP) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (check(s.substring(i, i + p.length()), new HashMap<>(map))) {
                ans.add(i);
            }
        }
        return ans;
    }

    boolean check(String s, HashMap<Character, Integer> map) {
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                count--;
                if (count == 0) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), count);
                }
            } else {
                return false;
            }
        }
        return map.size() == 0;
    }
}
