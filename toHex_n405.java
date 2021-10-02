package leetcode;

/**
 * @program: first
 * @description: 数字转换为16进制
 * @author: panhao
 * @date: 2021-10-02 21:15
 **/
public class toHex_n405 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        long n = num;
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            n = (long) (num + Math.pow(2, 32));
        }
        while (n > 0) {
            long u = n % 16;
            char c = (char) (u + '0');
            if (u >= 10) {
                c = (char) (u - 10 + 'a');
            }
            sb.append(c);
            n /= 16;
        }
        return sb.reverse().toString();
    }
}
