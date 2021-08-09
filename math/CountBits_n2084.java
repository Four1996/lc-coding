package leetcode.math;

/**
 * @program: first
 * @description: 前n个数字二进制中1的个数
 * @author: panhao
 * @date: 2021-08-09 18:43
 **/
public class CountBits_n2084 {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int num = i;
            int count = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    count++;
                }
                num >>= 1;
            }
            ans[i] = count;
        }
        return ans;
    }
}
