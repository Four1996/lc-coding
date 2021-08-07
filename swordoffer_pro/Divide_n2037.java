package leetcode.swordoffer_pro;

/**
 * @program: first
 * @description: 整数除法
 * @author: panhao
 * @date: 2021-08-07 17:03
 **/
public class Divide_n2037 {
    public static int divide(int a, int b) {
        if (a == 0) return 0;
        if (b == 1) return a;
        if (b == -1) {
            if (a == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            else return -a;
        }
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        long aa=a,bb=b;
        aa = aa > 0 ? aa : -aa;
        bb = bb > 0 ? bb : -bb;
        long res = div(aa, bb);
        if (sign > 0) return res>Integer.MAX_VALUE?Integer.MAX_VALUE: (int) res;
        return (int) -res;
    }

    public static long div(long a, long b) {
        if (a < b) return 0;
        long count = 1;
        long temp = b;
        while ((temp + temp) <= a) {
            count = count + count;
            temp = temp + temp;
        }
        return count + div(a - temp, b);
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648,2));
    }
}
