package leetcode.array;

import java.util.*;

/**
 * @program: first
 * @description: 从相邻元素对还原数组
 * @author: panhao
 * @date: 2021-07-25 16:24
 **/
public class RestoreArray_n1743 {
    public static int[] restoreArray(int[][] adjacentPairs) {
        int len = adjacentPairs.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            List<Integer> list0 = map.getOrDefault(adjacentPair[0], new ArrayList<>());
            list0.add(adjacentPair[1]);
            map.put(adjacentPair[0], list0);
            List<Integer> list1 = map.getOrDefault(adjacentPair[1], new ArrayList<>());
            list1.add(adjacentPair[0]);
            map.put(adjacentPair[1], list1);
        }
        int[] ans = new int[len + 1];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() == 1) {
                ans[0] = entry.getKey();
                break;
            }
        }
        ans[1] = map.get(ans[0]).get(0);
        for (int i = 2; i < ans.length; i++) {
            List<Integer> list = map.get(ans[i - 1]);
            for (int num : list) {
                if (num == ans[i - 1] || num == ans[i - 2]) continue;
                else ans[i] = num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {2, 1}, {3, 4}, {3, 2}
        };
        System.out.println(restoreArray(nums));
    }
}
