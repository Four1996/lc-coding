package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description: 减小和重新排列数组后的最大元素
 * @author: panhao
 * @date: 2021-07-15 08:49
 **/
public class MaximumElementAfterDecrementingAndRearranging_n1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        if (len < 2) return 1;
        if (arr[0] != 1) arr[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            int abs = Math.abs(arr[i] - arr[i - 1]);
            if (abs > 1) {
                arr[i] = arr[i - 1] + 1;
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
