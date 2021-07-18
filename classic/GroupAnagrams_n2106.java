package leetcode.classic;

import java.util.*;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-18 09:23
 **/
public class GroupAnagrams_n2106 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s1 = new String(chars);
            if (map.containsKey(s1)) {
                List<String> list = map.get(s1);
                list.add(s);
            } else {
                map.put(s1, new ArrayList<>(Arrays.asList(s)));
            }
        }
        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
