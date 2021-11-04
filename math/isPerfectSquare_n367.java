package leetcode.math;

/**
 * @program: first
 * @description: 有效的完全平方数
 * @author: panhao
 * @date: 2021-11-04 21:04
 **/
public class isPerfectSquare_n367 {
    public static boolean isPerfectSquare(int num) {
        long left = 1, right = num / 2;
        System.out.println(Math.pow(808201,0.5));
        while (left < right) {
            long mid = (left + right) >> 1;
            if ((mid * mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left * left == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
}
