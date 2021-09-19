package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-18 23:19
 **/
public class maxTaxiEarnings_n5861 {
    public static long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (o1, o2) -> {
            if (o1[1]==o2[1]){
                if (o1[0]==o2[0]){
                    return o2[2]-o1[2];
                }else{
                    return o1[0]-o2[0];
                }
            }else{
                return o1[1]-o2[1];
            }
        });
        for(int i = 0; i < rides.length; i++) {
            rides[i][0]--;
            rides[i][1]--;
        }
        long[] res = new long[n];
        int ind = 0;
        for(int i = 1; i < n; i++) {
            res[i] = Math.max(res[i], res[i - 1]);
            while(ind < rides.length && rides[ind][1] <= i) {
                res[i] = Math.max(res[i], res[rides[ind][0]] + rides[ind][1] - rides[ind][0] + rides[ind][2]);
                ind++;
            }
        }
        //System.out.println(Arrays.toString(res));
        return res[n - 1];
    }

    public static void main(String[] args) {
        int[][] nums={
                {1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}
        };
        System.out.println(maxTaxiEarnings(20,nums));
    }
}
