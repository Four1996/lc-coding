package leetcode;

/**
 * @author panhao
 * @date 2021年05月05日 9:20 下午
 */
public class TailingZeroes_n172 {
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(7));
    }
}
