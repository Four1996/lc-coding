package leetcode.double_pointer;

import test.ProxyTest.Lenovo;

import java.util.*;

/**
 * @program: first
 * @description: 找到字符串中的所有字母异位词
 * @author: panhao
 * @date: 2021-07-07 10:20
 **/
public class FindAnagrams_n438 {
    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> compare = new HashMap<>();
        HashMap<Character, Integer> origin = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            origin.put(p.charAt(i), origin.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, count = 0;
        List<Integer> ans = new ArrayList<>();
        char[] s_chars = s.toCharArray();
        while (right < s.length()) {
            char c = s_chars[right];
            if (origin.containsKey(c)) {
                compare.put(c, compare.getOrDefault(c, 0) + 1);
            } else {
                left = right + 1;
                compare.clear();
            }
            if (right - left + 1 == p.length()) {
                for (Map.Entry<Character, Integer> entry : origin.entrySet()) {
                    Character key = entry.getKey();
                    Integer value = entry.getValue();
                    if (value.equals(compare.get(key))) {
                        count += value;
                    } else {
                        break;
                    }
                }
            }
            if (count == p.length()) {
                ans.add(left);
            }
            if (right - left + 1 == p.length()) {
                int integer = compare.getOrDefault(s_chars[left], 0);
                integer--;
                if (integer <= 0 && compare.containsKey(s_chars[left])) compare.remove(s_chars[left]);
                else {
                    compare.put(s_chars[left], integer);
                }
                left++;
            }
            right++;
            count = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
