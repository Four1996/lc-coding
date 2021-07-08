package leetcode;

import java.util.Stack;

/**
 * @program: first
 * @description: 递增的三元子序列
 * @author: panhao
 * @date: 2021-07-07 17:24
 **/
public class IncreasingTriplet_n334 {
    public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        int one = Integer.MAX_VALUE, two = Integer.MAX_VALUE;
        for (int three : nums) {
            if (three > two) return true;
            else if (three <= one) one = three;
            else two = three;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {20, 100, 10, 12, 5, 13};
        System.out.println(increasingTriplet(nums));
    }
}
