package leetcode.math;

/**
 * @program: first
 * @description: 换酒问题
 * @author: panhao
 * @date: 2021-12-17 09:48
 **/
public class numWaterBottles_n1518 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int rest = numBottles, empty = 0;
        while (rest + empty >= numExchange) {
            ans += ((rest + empty) / numExchange);
            int temp_empty=empty,temp_rest=rest;
            rest = ((temp_rest + temp_empty) / numExchange);
            empty = ((temp_rest + temp_empty) % numExchange);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9,3));
    }
}
