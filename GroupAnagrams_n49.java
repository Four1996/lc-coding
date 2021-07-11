package leetcode;

import java.util.*;

/**
 * @program: first
 * @description: 字母异位词分组
 * @author: panhao
 * @date: 2021-07-10 21:41
 **/
public class GroupAnagrams_n49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = Arrays.toString(chars);
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
                map.put(s, list);
            } else {
                map.put(s, new ArrayList<>(Arrays.asList(str)));
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            ans.add(value);
        }

        return ans;
    }
}
