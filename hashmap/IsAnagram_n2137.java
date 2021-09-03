package leetcode.hashmap;

import java.util.HashMap;

/**
 * @program: first
 * @description: 有效的变位词
 * @author: panhao
 * @date: 2021-09-03 10:29
 **/
public class IsAnagram_n2137 {
    public boolean isAnagram(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        if (s.equals(t) || l1 != l2) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars1) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : chars2) {
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                count--;
                if (count == 0) {
                    map.remove(c);
                } else {
                    map.put(c, count);
                }
            } else {
                return false;
            }
        }
        return map.size() == 0;
    }
}
