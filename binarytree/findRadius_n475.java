package leetcode.binarytree;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @program: first
 * @description: 供暖器
 * @author: panhao
 * @date: 2021-12-20 20:16
 **/
public class findRadius_n475 {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> heaters_tree = new TreeSet<>();
        for (int heater : heaters) {
            heaters_tree.add(heater);
        }
        int maxDistance = 0;
        for (int house : houses) {
            Integer ceiling = heaters_tree.ceiling(house);
            Integer floor = heaters_tree.floor(house);
            int dis = Integer.MAX_VALUE;
            if (ceiling == null) {
                dis = house - floor;
            } else if (floor == null) {
                dis = ceiling - house;
            } else {
                dis = Math.min(Math.abs(ceiling - house), Math.abs(floor - house));
            }
            maxDistance = Math.max(dis, maxDistance);
        }
        return maxDistance;
    }
}
