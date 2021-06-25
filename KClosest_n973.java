package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author panhao
 * @date 2021年05月20日 3:57 下午
 */
public class KClosest_n973 {
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int x1=o1[0];
                int y1=o1[1];
                int x2=o2[0];
                int y2=o2[1];
                int dis1=x1*x1+y1*y1;
                int dis2=x2*x2+y2*y2;
                return (dis2-dis1);
            }
        });
        int[][] ans=new int[k][2];
        for (int[] u: points){
            queue.add(u);
            if (queue.size()>k) queue.poll();
        }
        int i=0;
        while (queue.size()>0){
            int[] num=queue.poll();
            ans[i][0]=num[0];
            ans[i][1]=num[1];
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums={
                {3,3},
                {5,-1},
                {-2,4}
        };
        System.out.println(kClosest(nums,2));
    }
}
