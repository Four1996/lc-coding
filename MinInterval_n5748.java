package leetcode;

import java.awt.geom.AffineTransform;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author panhao
 * @date 2021年05月02日 11:00 上午
 */
public class MinInterval_n5748 {
    public static int[] minInterval(int[][] intervals, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i=0;i<queries.length;i++){
            int left=0,right=intervals.length-1;
            while (left<right){
                int mid=(left+right)/2;
                if (intervals[mid][0]<=queries[i]) left=mid+1;
                else right=mid;
            }
            if (left==0&&intervals[left][0]>queries[i]) ans[i]=-1;
            else{
                if (intervals[left][0]>queries[i]) left--;
                right=left;
                left=0;
                int[][] dump=Arrays.copyOfRange(intervals,left,right+1);
                Arrays.sort(dump, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1]-o2[1];
                    }
                });
                while (left<right){
                    int mid=(left+right)/2;
                    if (dump[mid][1]<queries[i]) left=mid+1;
                    else right=mid;
                }
                if (right==dump.length-1&&dump[right][1]<queries[i]) ans[i]=-1;
                else{
//                    if (dump[left][1]>queries[i]&&left!=0) left--;
                    int min=Integer.MAX_VALUE;
                    for (int j=left;j< dump.length;j++){
                        min=min>(dump[j][1]-dump[j][0]+1)?(dump[j][1]-dump[j][0]+1):min;
                    }
                    ans[i]=min;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a={{2,3},{2,5},{1,8},{20,25}};
        int[] b={2,19,5,22};
        for (int i:minInterval(a,b)){
            System.out.println(i);
        }
    }
}
