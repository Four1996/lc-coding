package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @program: first
 * @description: 直线上最多的点数
 * @author: panhao
 * @date: 2021-06-24 09:31
 **/
public class MaxPoints_n149 {

    public static int maxPoints(int[][] points) {
        int len = points.length;
        HashMap<Float, Integer> slop = new HashMap<>();
        int max = 0;
        for (int i = 0; i < len; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = 0; j < len; j++) {
                if (j == i) continue;
                int x2 = points[j][0];
                int y2 = points[j][1];
                float k;
                if (x2 == x1) {
                    k = Float.MAX_VALUE;
                } else {
                    k = (float) ((y2 - y1) / ((x2 - x1) * 1.0));
                }
                int count = slop.getOrDefault(k, 0) + 1;
                max = Math.max(max, count);
                slop.put(k, count);
            }
            slop.clear();
        }
        return max + 1;
    }

    public static void main(String[] args) {
        int[][] nums={
                {1,1},
                {3,2},
                {5,3},
                {4,1},
                {2,3},
                {1,4}
        };
        System.out.println(maxPoints(nums));
    }
}
