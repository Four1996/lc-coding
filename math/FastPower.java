package leetcode.math;

/**
 * @program: first
 * @description: 快速幂
 * @author: panhao
 * @date: 2021-08-07 20:29
 **/
public class FastPower {
    public static int fastPower(int a,int b) {
        int ans = 1, base = a;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans *= base;
            }
            base *= base;
            b = b >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fastPower(5,11));
    }
}
