package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: first
 * @description: 范围求和II
 * @author: panhao
 * @date: 2021-11-07 20:24
 **/
public class maxCount_n598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        Arrays.sort(ops, (o1, o2) -> o1[0] - o2[0]);
        int row = ops[0][0];
        Arrays.sort(ops, (o1, o2) -> o1[1] - o2[1]);
        int col = ops[0][1];
        return row * col;
    }
}
