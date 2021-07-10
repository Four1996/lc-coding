package leetcode;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @program: first
 * @description: 基于时间的键值存储
 * @author: panhao
 * @date: 2021-07-10 09:36
 **/
public class TimeMap_n981 {
    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap_n981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            TreeMap<Integer, String> treeMap = new TreeMap<>();
            treeMap.put(timestamp, value);
            map.put(key, treeMap);
        } else {
            TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
            if (treeMap != null) {
                treeMap.put(timestamp, value);
                map.put(key, treeMap);
            }
        }
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
            Integer integer = null;
            if (treeMap != null) integer = treeMap.floorKey(timestamp);
            if (integer == null) return "";
            else return treeMap.get(integer);
        } else {
            return "";
        }
    }
}
