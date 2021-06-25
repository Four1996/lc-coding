package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年05月30日 10:12 上午
 */
public class MinimumXORSum_n5756 {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int len=nums1.length;
        int n = nums1.length;
        int[] f = new int[1<<n];
        int INF = (int)1e9;
        Arrays.fill(f,INF);
        f[0] = 0;
        for(int i = 1;i < 1<<n;i++) {
            int sum = 0;
            for(int j = 0;j < n;j++) {
                int u = i >> j & 1;
                if(u == 1) {
                    sum++;
                }
            }
            for(int j = 0;j < n;j++) {
                int u = i >> j & 1;
                if(u == 1) {
                    f[i] = Math.min(f[i],f[i - (1 << j)] + (nums2[j] ^ nums1[sum - 1]));
                }
            }
        }
        return f[(1<<n)-1];
    }
}
