package leetcode.array;

import java.util.Arrays;

/**
 * @program: first
 * @description: 航班预订统计
 * @author: panhao
 * @date: 2021-08-31 09:39
 **/
public class CorpFlightBookings_n1109 {
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            int s = booking[0];
            int e = booking[1];
            int seat = booking[2];
            while (s <= e) {
                ans[s - 1] += seat;
                s++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums={
                {1,2,10},{2,3,20},{2,5,25}
        };
        System.out.println(Arrays.toString(corpFlightBookings(nums, 5)));
    }
}
