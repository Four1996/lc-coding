package leetcode;

import java.util.*;

/**
 * @author panhao
 * @date 2021年04月11日 3:32 下午
 */
public class NthUglyNumber_n264 {
    public static int nthUglyNumber(int n) {
        int[] nums={2,3,5};
        if (n==1) return 1;
        Queue<Long> q=new PriorityQueue<>();
        q.add(1L);
        Set<Long> set=new HashSet<>();
        set.add(1L);
        int count=0;
        while(count!=n){
            long x=q.poll();
            count++;
            if (count==n) return (int)x;
            for (int i=0;i<nums.length;i++){
                long t=x*nums[i];
                if (!set.contains(t)){
                    q.add(t);
                    set.add(t);
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
