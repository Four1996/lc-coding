package leetcode.strings;

import java.util.*;

/**
 * @program: first
 * @description: 重复的DNA序列
 * @author: panhao
 * @date: 2021-10-08 15:20
 **/
public class findRepeatedDnaSequences_n187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        HashSet<String> set = new HashSet<>();
        int l = 0, r = l + 9;
        List<String> ans = new ArrayList<>();
        Set<String> res = new HashSet<>();
        while (r < len) {
            String temp = s.substring(l, r + 1);
            if (set.contains(temp)) {
                if (!res.contains(temp)) {
                    ans.add(temp);
                    res.add(temp);
                }
            } else {
                set.add(temp);
            }
            l++;
            r++;
        }
        return ans;
    }
}
