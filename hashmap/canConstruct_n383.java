package leetcode.hashmap;

import java.util.HashMap;

/**
 * @program: first
 * @description: 赎金信
 * @author: panhao
 * @date: 2021-12-04 17:01
 **/
public class canConstruct_n383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars1 = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        for (char c : chars2) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : chars1) {
            if (map.containsKey(c)) {
                int num = map.get(c);
                num--;
                if (num == 0) {
                    map.remove(c);
                } else {
                    map.put(c, num);
                }

            } else {
                return false;
            }
        }
        return true;
    }
}
