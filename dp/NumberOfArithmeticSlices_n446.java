package leetcode.dp;

import java.util.*;

/**
 * @program: first
 * @description: 等差数列划分II -子序列
 * @author: panhao
 * @date: 2021-08-11 10:10
 **/
public class NumberOfArithmeticSlices_n446 {


    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        // 每个 f[i] 均为哈希表，哈希表键值对为 {d : cnt}
        // d : 子序列差值
        // cnt : 以 nums[i] 为结尾，且差值为 d 的子序列数量
        List<Map<Long, Integer>> f = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map<Long, Integer> cur = new HashMap<>();
            for (int j = 0; j < i; j++) {
                Long d = nums[i] * 1L - nums[j];
                Map<Long, Integer> prev = f.get(j);
                int cnt = cur.getOrDefault(d, 0);
                cnt += prev.getOrDefault(d, 0);
                cnt ++;
                cur.put(d, cnt);
            }
            f.add(cur);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Long, Integer> cur = f.get(i);
            for (Long key : cur.keySet()) {
                ans += cur.get(key);
            }
        }
        int a1 = 0, an = n - 1;
        int cnt = (a1 + an) * n / 2;
        return ans - cnt;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10};
        System.out.println(numberOfArithmeticSlices(nums));
    }
}
