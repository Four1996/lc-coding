package leetcode.strings;

import java.io.FileReader;
import java.util.*;

/**
 * @program: first
 * @description: 反转字符串中的元音字母
 * @author: panhao
 * @date: 2021-08-19 08:20
 **/
public class ReverseVowels_n345 {
    public String reverseVowels(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        HashSet<Character> set = new HashSet<>();
        for (char c : chars) {
            if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U') {
                deque.addFirst(c);
                set.add(c);
            }
        }
        for (int i = 0; i < len; i++) {
            if (set.contains(chars[i])) {
                chars[i] = deque.pollFirst();
            }
        }
        return new String(chars);
    }
}
