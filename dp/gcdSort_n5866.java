package leetcode.dp;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-05 16:33
 **/
public class gcdSort_n5866 {
    public static boolean gcdSort(int[] nums) {
        int len = nums.length;
        return false;
    }

    public static int gcd(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }
        if (num1%2==0&&num2%2==0){
            while (num1%2==0&&num2%2==0){
                num1/=2;
                num2/=2;
            }
        }
        if (num1 == num2) {
            return num1;
        }
        int small = Math.min(num1, num2);
        int big = Math.max(num1, num2);
        int diff = big - small;
        while (diff != small) {
            big = Math.max(diff, small);
            small = Math.min(diff, small);
            diff = big - small;
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(gcd(260,104));
    }
}
