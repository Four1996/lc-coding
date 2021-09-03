package leetcode.hashmap;

import java.util.*;

/**
 * @program: first
 * @description: 变位词组
 * @author: panhao
 * @date: 2021-09-03 10:43
 **/
public class GroupAnagrams_n2138 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            ans.add(list);
        }
        return ans;
    }
}
