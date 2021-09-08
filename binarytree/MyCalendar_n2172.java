package leetcode.binarytree;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @program: first
 * @description: 日程表
 * @author: panhao
 * @date: 2021-09-07 15:25
 **/
public class MyCalendar_n2172 {
    TreeMap<Integer, Integer> map;

    public MyCalendar_n2172() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer pre = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if ((pre == null || map.get(pre) <= start) && (next == null || end <= next)) {
            map.put(start, end);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendar_n2172 m = new MyCalendar_n2172();
        m.book(10, 20);
        m.book(15, 25);
        m.book(20, 30);
    }
}
