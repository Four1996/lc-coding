package leetcode;

/**
 * @author panhao
 * @date 2021年05月31日 9:46 上午
 */
public class IsPowerOfFour_n342 {
    public boolean isPowerOfFour(int n) {
        return n>0&&(n&(n-1))==0&&(n&0xaaaaaaaa)==0;
    }

    public static void main(String[] args) {
        System.out.println(new IsPowerOfFour_n342().isPowerOfFour(5));
    }
}
