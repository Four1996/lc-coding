package leetcode.swordoffer;

import java.util.*;

/**
 * @author panhao
 * @date 2021年06月03日 8:38 下午
 */
public class FirstUniqChar_n1972 {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }

    public static void main(String[] args) {
        String s="aadadaaa";
        System.out.println(new FirstUniqChar_n1972().firstUniqChar(s));
    }
}
