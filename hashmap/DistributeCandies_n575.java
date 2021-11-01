package leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: first
 * @description: 分糖果
 * @author: panhao
 * @date: 2021-11-01 14:55
 **/
public class DistributeCandies_n575 {
    public int distributeCandies(int[] candyType) {
        int l = candyType.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : candyType) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int diff = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            if (count == 1) {
                ans++;
            } else {
                diff++;
            }
        }
        if (ans < l / 2) {
            return Math.min((ans + diff), (l / 2));
        } else {
            return l / 2;
        }
    }
}
