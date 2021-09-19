package leetcode.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-19 10:53
 **/
public class DetectSquares_n5877 {
    HashMap<String, Integer> map;

    public DetectSquares_n5877() {
        map = new HashMap<>();

    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        String key = x + " " + y;
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int ans = 0;
        for (String s : map.keySet()) {
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            int tempX = Math.abs(x - a);
            int tempY = Math.abs(y - b);
            if (tempY == 0 || tempX != tempY) {
                continue;
            }
            String key1 = x + " " + b;
            String key2 = a + " " + y;
            if (map.containsKey(key1) && map.containsKey(key2)) {
                ans += map.get(s) * map.get(key1) * map.get(key2);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DetectSquares_n5877 d = new DetectSquares_n5877();
        d.add(new int[]{419, 351});
        d.add(new int[]{798, 351});
        d.add(new int[]{798, 730});
        System.out.println(d.count(new int[]{419, 730}));
        // System.out.println(d.count(new int[]{14, 8}));
        // d.add(new int[]{11,2});
        // System.out.println(d.count(new int[]{11, 10}));

    }
}
