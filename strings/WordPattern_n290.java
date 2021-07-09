package leetcode.strings;

import java.util.HashMap;

/**
 * @program: first
 * @description: 单词规律
 * @author: panhao
 * @date: 2021-07-09 15:57
 **/
public class WordPattern_n290 {
    public static boolean wordPattern(String pattern, String s) {

        String[] s1 = s.split(" ");
        char[] chars = pattern.toCharArray();
        int len = pattern.length();
        int l1 = s1.length;
        if (len != l1) return false;
        HashMap<Character, String> p = new HashMap<>();
        HashMap<String, Character> str = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char cc = chars[i];
            String ss = s1[i];
            if (p.isEmpty() && str.isEmpty()) {
                p.put(cc, ss);
                str.put(ss, cc);
            } else {
                if (p.containsKey(cc) || str.containsKey(ss)) {
                    String s2 = p.getOrDefault(cc, null);
                    Character c2 = str.getOrDefault(ss, null);
                    if (s2 == null || c2 == null) return false;
                    if (!s2.equals(ss) || !c2.equals(cc)) return false;
                } else {
                    p.put(cc, ss);
                    str.put(ss, cc);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern="abba";
        String s="dog cat cat dog";
        System.out.println(wordPattern(pattern,s));
    }
}
