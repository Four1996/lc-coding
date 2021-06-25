package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月20日 2:27 下午
 */
public class IsPossible_n659 {
    public static boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> numcount = new HashMap<>();
        HashMap<Integer, Integer> tailcount = new HashMap<>();
        for (int u : nums) {
            if (numcount.containsKey(u)) numcount.put(u, numcount.getOrDefault(u, 0) + 1);
            else numcount.put(u, 1);
            tailcount.put(u, 0);
        }
        for (int u : nums) {
            if (numcount.get(u) <= 0) continue;
            else if (tailcount.getOrDefault(u - 1, 0) > 0) {
                numcount.put(u, numcount.get(u) - 1);
                tailcount.put(u - 1, tailcount.get(u - 1) - 1);
                tailcount.put(u, tailcount.get(u) + 1);
            } else if (numcount.getOrDefault(u + 1, 0) > 0 && numcount.getOrDefault(u + 2, 0) > 0) {
                numcount.put(u, numcount.get(u) - 1);
                numcount.put(u + 1, numcount.get(u + 1) - 1);
                numcount.put(u + 2, numcount.get(u + 2) - 1);
                tailcount.put(u + 2, tailcount.getOrDefault(u + 2, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 5, 6, 7};
        System.out.println(isPossible(nums));
    }
}