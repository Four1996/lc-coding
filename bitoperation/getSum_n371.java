package leetcode.bitoperation;

/**
 * @program: first
 * @description: 两整数之和
 * @author: panhao
 * @date: 2021-09-26 09:40
 **/
public class getSum_n371 {
    public int getSum(int a, int b) {
        int sum=a^b;
        int carray=(a&b)<<1;
        if (carray!=0){
            return getSum(sum,carray);
        }
        return sum;
    }
}
