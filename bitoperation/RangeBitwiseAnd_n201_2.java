package leetcode.bitoperation;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-14 10:03
 **/
public class RangeBitwiseAnd_n201_2 {
    public static int rangeBitwiseAnd(int left, int right) {
        if (left == right) return left;
        int res = left ^ right;
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if (res >> i == 1) {
                break;
            } else {
                count++;
            }
        }
        count = 31 - count;
        return (left >> count) << count;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(2,4));
    }
}
