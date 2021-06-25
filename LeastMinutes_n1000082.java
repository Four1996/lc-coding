package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-06-19 15:00
 **/
public class LeastMinutes_n1000082 {
    public static int leastMinutes(int n) {
        int day=1;
        int sum=1;
        while (sum<n){
            sum*=2;
            day++;
        }
        return day;
    }

    public static void main(String[] args) {
        System.out.println(leastMinutes(7));
    }
}
