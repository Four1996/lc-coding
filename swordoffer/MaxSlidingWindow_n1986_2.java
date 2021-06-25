package leetcode.swordoffer;

import java.util.*;

/**
 * @author panhao
 * @date 2021年06月05日 10:36 上午
 */
public class MaxSlidingWindow_n1986_2 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length<2||nums==null) return nums;
        Deque<Integer> deque=new LinkedList<>();
        int[] ans=new int[nums.length-k+1];
        for (int i=0;i<k;i++){
            while (!deque.isEmpty()&&nums[i]>deque.peekLast()) deque.removeLast();
            deque.add(nums[i]);
        }
        int idx=0;
        ans[idx++]=deque.peekFirst();
        for (int i=k;i<nums.length;i++){
            if (nums[i-k]==deque.peekFirst()) deque.removeFirst();
            while (!deque.isEmpty()&&nums[i]>deque.peekLast()) deque.removeLast();
            deque.add(nums[i]);
            ans[idx++]=deque.peekFirst();
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
