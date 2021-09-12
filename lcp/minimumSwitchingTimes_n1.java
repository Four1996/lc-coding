package leetcode.lcp;

import java.util.HashMap;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-11 15:00
 **/
public class minimumSwitchingTimes_n1 {
    public static int minimumSwitchingTimes(int[][] source, int[][] target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] nums : source) {
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int ans = 0;
        for (int[] nums : target) {
            for (int num : nums) {
                if (map.containsKey(num)) {
                    int count = map.get(num);
                    count--;
                    if (count > 0) {
                        map.put(num, count);
                    } else {
                        map.remove(num);
                    }
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] source={
                {1,3},{5,4}
        };
        int[][] tar={
                {3,1},{6,5}
        };
        System.out.println(minimumSwitchingTimes(source,tar));
    }
}
