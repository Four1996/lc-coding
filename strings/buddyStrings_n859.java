package leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: first
 * @description: 亲密字符串
 * @author: panhao
 * @date: 2021-11-23 18:32
 **/
public class buddyStrings_n859 {
    public static boolean buddyStrings(String s, String goal) {
        int l1 = s.length(), l2 = goal.length();
        if (l1 != l2) {
            return false;
        }
        HashSet<Character> set = new HashSet<>();
        if (s.equals(goal)) {
            for (int i = 0; i < l1; i++) {
                if (set.contains(s.charAt(i))) {
                    return true;
                } else {
                    set.add(s.charAt(i));
                }
            }
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < l1; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                s1.append(s.charAt(i));
                s2.append(goal.charAt(i));
            }
        }
        if (s1.length() != 2) {
            return false;
        } else {
            return s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0);
        }
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "ca";
        System.out.println(buddyStrings(s1, s2));
    }
}
