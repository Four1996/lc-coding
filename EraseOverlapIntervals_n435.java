package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * @program: first
 * @description: 无重叠区间
 * @author: panhao
 * @date: 2021-07-06 22:13
 **/
public class EraseOverlapIntervals_n435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int len=intervals.length;
        if (len<2) return 0;
        int ans=0;
        int end=intervals[0][1];
        for (int i=1;i<len;i++){
            if (intervals[i][0]<end){
                end=Math.min(end,intervals[i][1]);
                ans++;
            }else{
                end=intervals[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums={
                {1,2},{2,3},{3,4},{1,3}
        };
        System.out.println(eraseOverlapIntervals(nums));
    }
}
