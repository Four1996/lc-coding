package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: Bigram分词
 * @author: panhao
 * @date: 2021-12-27 22:08
 **/
public class findOcurrences_n1078 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> temp = new ArrayList<>();
        String[] s = text.split(" ");
        int l = 0, r = 1;
        if (s.length < 3) {
            return null;
        } else {
            for (int i = 2; i < s.length; i++) {
                if (s[l].equals(first) && s[r].equals(second)) {
                    temp.add(s[i]);
                }
                l++;
                r++;
            }
        }

        String[] ans = new String[temp.size()];
        int idx = 0;
        for (String s1 : temp) {
            ans[idx++] = s1;
        }
        return ans;
    }
}
