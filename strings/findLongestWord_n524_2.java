package leetcode.strings;

import java.util.*;

/**
 * @program: first
 * @description: 通过删除字母匹配到字典里最长单词
 * @author: panhao
 * @date: 2021-09-14 09:46
 **/
public class findLongestWord_n524_2 {
    public String findLongestWord(String s, List<String> list) {
        Collections.sort(list, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });
        int n = s.length();
        for (String ss : list) {
            int m = ss.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == m) {
                return ss;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        findLongestWord_n524_2 f = new findLongestWord_n524_2();
        String[] strs = {"ale", "apple", "monkey", "plea", "abpcplaaa", "abpcllllll", "abccclllpppeeaaaa"};
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(strs));
        String s = "abpcplea";
        System.out.println(f.findLongestWord(s, list));
    }
}
