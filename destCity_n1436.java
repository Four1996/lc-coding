package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @program: first
 * @description: 旅行终点站
 * @author: panhao
 * @date: 2021-10-01 22:22
 **/
public class destCity_n1436 {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
            set.add(path.get(0));
            set.add(path.get(1));
        }
        for (String s : set) {
            if (!map.containsKey(s)) {
                return s;
            }
        }
        return null;
    }
}
