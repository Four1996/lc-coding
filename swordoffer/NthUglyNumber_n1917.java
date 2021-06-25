package leetcode.swordoffer;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author panhao
 * @date 2021年06月03日 7:34 下午
 */
public class NthUglyNumber_n1917 {
    public int nthUglyNumber(int n) {
        int[] nums={2,3,5};
        HashSet<Long> set=new HashSet<>();
        PriorityQueue<Long> queue=new PriorityQueue<>();
        set.add(1L);
        queue.add(1L);
        int ugly=0;
        for (int i=0;i<n;i++){
            long poll = queue.poll();
            ugly= (int) poll;
            for (int num : nums) {
               long next= num*poll;
               if (!set.contains(next)){
                    set.add(next);
                    queue.add(next);
               }
            }
        }
        return ugly;
    }


    public static void main(String[] args) {
        System.out.println(new NthUglyNumber_n1917().nthUglyNumber(1352));
    }
}
