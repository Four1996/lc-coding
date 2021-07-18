package leetcode;

import java.util.HashSet;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-18 10:30
 **/
public class CanBeTypedWords_n5161 {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] s = text.split(" ");
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }
        int ans = 0;
        for (String s1 : s) {
            int len = s1.length();
            int i = 0;
            for (; i < len; i++) {
                char c = s1.charAt(i);
                if (set.contains(c)) break;
            }
            if (i == len) ans++;
        }
        return ans;
    }

}
