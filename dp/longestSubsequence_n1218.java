package leetcode.dp;

import java.util.HashMap;

/**
 * @program: first
 * @description: 最长定差子序列
 * @author: panhao
 * @date: 2021-11-05 20:26
 **/
public class longestSubsequence_n1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int l = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int ans = 0;
        for (int i = l - 1; i >= 0; i--) {
            int cur = arr[i];
            map.put(cur, map.getOrDefault(cur + difference, 0) + 1);
            ans = Math.max(ans, map.get(cur));
        }
        return ans;
    }
}
