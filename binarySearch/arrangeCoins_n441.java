package leetcode.binarySearch;

/**
 * @program: first
 * @description: 排列硬币
 * @author: panhao
 * @date: 2021-10-10 14:35
 **/
public class arrangeCoins_n441 {
    public static int arrangeCoins(int n) {
        long left = 1, right = n;
        while (left < right) {
            long mid = (left + right + 1) >> 1;
            if (check(mid, n)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) left;
    }

    public static boolean check(long x, int n) {
        return (x * (x + 1)) / 2 <= n;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
    }
}
