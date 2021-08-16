package leetcode.array;

/**
 * @program: first
 * @description: 数组元素的最小非零乘积
 * @author: panhao
 * @date: 2021-08-15 20:32
 **/
public class MinNonZeroProduct_n5844 {
    long mod = (long) (1e9 + 7);

    public int minNonZeroProduct(int p) {
        long base = (1L << p) % mod - 2;
        long b = (1L << (p - 1)) - 1;
        long first = fastPower(base, b) % mod;
        long second = (1L << p) % mod - 1;
        return (int) ((first * second) % mod);
    }

    public long fastPower(long a, long b) {
        long ans = 1L, base = a;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            b = b >> 1;
        }
        return ans;
    }
}
