package leetcode;

import java.util.HashMap;

/**
 * @program: first
 * @description: 大餐计数
 * @author: panhao
 * @date: 2021-07-07 08:49
 **/
public class CountPairs_n1711 {
    final int mod= (int) (1e9+7);
    public int countPairs(int[] deliciousness) {
        int ans = 0;
        int len = deliciousness.length;
        // 找最大值。
        int maxval = 0;
        for (int i : deliciousness) {
            maxval = Math.max(i, maxval);
        }
        // 得到该数组的最大和
        int maxSum = maxval * 2;
        // map中存数组中每个数的出现次数。
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int val = deliciousness[i];
            // 2的幂应该最大不超过maxSum。
            // 寻找数组中与当前数val的和正好为sum的数的数量。
            // 由于当前元素下标一定大于已经存在于map中的元素的下标，所以不可能存在重复计算。
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                ans = (ans + count) % mod;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return ans;
    }
}
