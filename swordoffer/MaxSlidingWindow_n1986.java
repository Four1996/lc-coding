package leetcode.swordoffer;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author panhao
 * @date 2021年06月05日 10:36 上午
 */
public class MaxSlidingWindow_n1986 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0) return new int[0];
        PriorityQueue<Integer> big_heap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int idx=0;
        while (idx<k){
            big_heap.add(nums[idx]);
            idx++;
        }
        int preindex=0;
        int pre=nums[preindex];
        List<Integer> list=new LinkedList<>();
        list.add(big_heap.peek());
        for (int i=idx;i<nums.length;i++){
            big_heap.remove(pre);
            big_heap.add(nums[i]);
            list.add(big_heap.peek());
            preindex++;
            pre=nums[preindex];
        }
        int[] ans=new int[list.size()];
        int i=0;
        for (Integer integer : list) {
            ans[i]=integer;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        for (int i : maxSlidingWindow(nums,3)) {
            System.out.println(i);
        }
    }
}
