package leetcode.dp;

/**
 * @program: first
 * @description: 斐波那契数
 * @author: panhao
 * @date: 2021-07-03 09:38
 **/
public class Fib_n509 {
    public int fib(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        return fib(n-1)+fib(n-2);
    }
}
