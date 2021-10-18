package leetcode.bitoperation;

/**
 * @program: first
 * @description: 数字的补数
 * @author: panhao
 * @date: 2021-10-18 14:59
 **/
public class findComplement_n476 {
    public static int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        char[] chars = s.toCharArray();
        int len = chars.length;
        long res = 0;
        int c = 0;
        for (int i = len - 1; i >= 0; i--) {
            int n = chars[i] - '0';
            n = n == 1 ? 0 : 1;
            res += n * Math.pow(2, c);
            c++;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(1));
    }
}
