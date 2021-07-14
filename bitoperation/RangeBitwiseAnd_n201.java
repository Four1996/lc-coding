package leetcode.bitoperation;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-14 10:03
 **/
public class RangeBitwiseAnd_n201 {
    public static int rangeBitwiseAnd(int left, int right) {
        while (left<right){
            right&=(right-1);
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(2,4));
    }
}
