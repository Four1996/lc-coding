package leetcode.math;

/**
 * @program: first
 * @description: 3的幂
 * @author: panhao
 * @date: 2021-09-23 15:32
 **/
public class isPowerOfThree_n326 {
    public boolean isPowerOfThree(int n) {
        // if (n<=0){
        //     return false;
        // }
        // while (n%3==0){
        //     n/=3;
        // }
        //
        // return n == 1;
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(3,19));
    }
}
