package leetcode;

/**
 * @author panhao
 * @date 2021年05月30日 9:35 上午
 */
public class IsPowerOfTwo_n231 {
    public boolean isPowerOfTwo(int n) {
        if (n<=0) return false;
        if (n==1) return true;
        while (n%2==0){
            n/=2;
        }
        return n==1;
    }

    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwo_n231().isPowerOfTwo(18));
    }
}
