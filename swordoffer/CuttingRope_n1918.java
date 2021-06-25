package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年05月18日 11:05 上午
 */
public class CuttingRope_n1918 {
    public int cuttingRope(int n) {
        if (n<4) return n-1;
        long rem=1;
        while (n>4){
            rem= (long) ((rem*3)%(1e+9+7));
            n-=3;
        }
        return (int) ((rem*n)%(1e+9+7));

    }

    public static void main(String[] args) {
        System.out.println(new CuttingRope_n1918().cuttingRope(54));
    }
}
