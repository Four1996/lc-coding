package leetcode.classic;

/**
 * @program: first
 * @description: 配对交换
 * @author: panhao
 * @date: 2021-07-05 17:54
 **/
public class ExchangeBits_n2082 {
    public int exchangeBits(int num) {
        int hex_odd = 0xaaaaaaaa;
        int hex_even = 0x55555555;
        int odd = num & hex_odd;
        int even = num & hex_even;
        int ans = (odd >> 1) + (even << 1);
        return ans;
    }
}
