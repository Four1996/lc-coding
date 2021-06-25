package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月06日 8:28 下午
 */
public class Add_n1997 {
    public int add(int a, int b) {
        if (a==0||b==0) return a==0?b:a;
        while (b!=0){
            int c=(a&b)<<1;
            int n=a^b;
            a=n;
            b=c;
        }
        return a;
    }
}
