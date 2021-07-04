package leetcode;


import test.ProxyTest.Lenovo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: first
 * @description: 合并区间
 * @author: panhao
 * @date: 2021-07-04 19:13
 **/
public class Merge_n56 {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length==0) return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> merged=new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
            if (i==0) merged.add(intervals[0]);
            else{
                int left=intervals[i][0],right=intervals[i][1];
                if (left>merged.get(merged.size()-1)[1]){
                    merged.add(intervals[i]);
                }else{
                    int r=merged.get(merged.size()-1)[1];
                    if (r<right){
                        merged.set(merged.size()-1,new int[]{merged.get(merged.size()-1)[0],right});
                    }
                }
            }
        }
        int[][] ans=new int[merged.size()][2];
        int idx=0;
        for (int[] ints : merged) {
            ans[idx++]=ints;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums={
                {1,3},{2,6},{8,10},{15,18}
        };
        for (int[] ints : merge(nums)) {
            System.out.println(ints[0]+","+ints[1]);
        }
    }
}
