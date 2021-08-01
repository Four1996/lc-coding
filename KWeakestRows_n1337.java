package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: first
 * @description: 矩阵中战斗力最弱的K行
 * @author: panhao
 * @date: 2021-08-01 09:44
 **/
public class KWeakestRows_n1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int[][] res = new int[row][2];
        int idx = 0;
        for (int[] nums : mat) {
            int sum = 0;
            for (int num : nums) {
                if (num == 0) break;
                else sum += num;
            }
            res[idx][0] = sum;
            res[idx][1] = idx;
            idx++;
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = res[i][1];
        }
        return ans;
    }
}
