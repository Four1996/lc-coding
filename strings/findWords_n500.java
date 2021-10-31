package leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: first
 * @description: 键盘行
 * @author: panhao
 * @date: 2021-10-31 10:28
 **/
public class findWords_n500 {
    String s1 = "qwertyuiop";
    String s1U = "QWERTYUIOP";
    String s2 = "asdfghjkl";
    String s2U = "ASDFGHJKL";
    String s3 = "zxcvbnm";
    String s3U = "ZXCVBNM";

    public String[] findWords(String[] words) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), 1);
            map.put(s1U.charAt(i), 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            map.put(s2.charAt(i), 2);
            map.put(s2U.charAt(i), 2);
        }
        for (int i = 0; i < s3.length(); i++) {
            map.put(s3.charAt(i), 3);
            map.put(s3U.charAt(i), 3);
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int num = 0;
            boolean tag = true;
            for (int i = 0; i < word.length(); i++) {
                if (i == 0) {
                    num = map.get(word.charAt(i));
                } else {
                    if (num != map.get(word.charAt(i))) {
                        tag = false;
                        break;
                    }

                }
            }
            if (tag) {
                res.add(word);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
