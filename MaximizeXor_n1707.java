package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author panhao
 * @date 2021年05月23日 9:39 上午
 */
public class MaximizeXor_n1707 {
    static int N = (int)1e5 * 32;
    static int[][] trie = new int[N][2];
    static int idx = 0;
    public MaximizeXor_n1707() {
        for (int i = 0; i <= idx; i++) {
            Arrays.fill(trie[i], 0);
        }
        idx = 0;
    }
    void add(int x) {
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (trie[p][u] == 0) trie[p][u] = ++idx;
            p = trie[p][u];
        }
    }
    int getVal(int x) {
        int ans = 0;
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1, b = 1 - a;
            if (trie[p][b] != 0) {
                p = trie[p][b];
                ans = ans | (b << i);
            } else {
                p = trie[p][a];
                ans = ans | (a << i);
            }
        }
        return ans ^ x;
    }
    public int[] maximizeXor(int[] nums, int[][] qs) {
        int m = nums.length, n = qs.length;

        // 使用哈希表将原本的顺序保存下来
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(qs[i], i);

        // 将 nums 与 queries[x][1] 进行「从小到大」进行排序
        Arrays.sort(nums);
        Arrays.sort(qs, (a, b)->a[1]-b[1]);

        int[] ans = new int[n];
        int loc = 0; // 记录 nums 中哪些位置之前的数已经放入 Trie
        for (int[] q : qs) {
            int x = q[0], limit = q[1];
            // 将小于等于 limit 的数存入 Trie
            while (loc < m && nums[loc] <= limit) add(nums[loc++]);
            if (loc == 0) {
                ans[map.get(q)] = -1;
            } else {
                ans[map.get(q)] = getVal(x);
            }
        }
        return ans;
    }


}
