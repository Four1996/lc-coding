package leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: first
 * @description: 回旋镖的数量
 * @author: panhao
 * @date: 2021-09-13 10:21
 **/
public class numberOfBoomerangs_n447 {
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                int a = (int) Math.pow(Math.abs(points[i][0] - points[j][0]), 2) + (int) Math.pow(Math.abs(points[i][1] - points[j][1]), 2);
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int n = entry.getValue();
                ans += (n * (n - 1));
            }
        }
        return ans;
    }
}
