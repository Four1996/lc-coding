package leetcode.double_pointer;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.HashMap;

/**
 * @program: first
 * @description: 字符串中的变位词
 * @author: panhao
 * @date: 2021-08-19 09:41
 **/
public class CheckInclusion_n2102 {
    public static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l2 < l1) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < l1; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int left = 0, right = l1 - 1;
        while (right < l2) {
            if (check(s2.substring(left, right + 1), new HashMap<>(map))) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

    static boolean check(String s, HashMap<Character, Integer> map) {
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                return false;
            } else {
                int count = map.get(s.charAt(i));
                count--;
                if (count == 0) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), count);
                }
            }
        }
        return map.size() == 0;
    }

    public static void main(String[] args) {
        String s1="ab";
        String s2="eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }
}
