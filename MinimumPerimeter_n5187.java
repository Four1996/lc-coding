package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-01 11:09
 **/
public class MinimumPerimeter_n5187 {
    public static long minimumPerimeter(long neededApples) {

        long res = 0;
        long sum=0;
        while (sum<neededApples){
            res++;
            sum+=12*res*res;
        }
        return res*2*4 ;
    }

    public static void main(String[] args) {
        System.out.println(minimumPerimeter(1000000000));
    }
}
