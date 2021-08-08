package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-08 10:43
 **/
public class MinStoneSum_n5839 {
    public static int minStoneSum(int[] piles, int k) {
        int sum=0;
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int pile : piles) {
            queue.add(pile);
            sum+=pile;
        }
        while (k>0){
            int cur = queue.poll();
            sum-=(cur/2);
            cur-=(cur/2);
            queue.add(cur);
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums={5,4,9};
        System.out.println(minStoneSum(nums,2));
    }
}
