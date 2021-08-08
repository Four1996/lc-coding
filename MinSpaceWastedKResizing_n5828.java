package leetcode;

import java.util.*;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-07 23:15
 **/
public class MinSpaceWastedKResizing_n5828 {
    public static int minSpaceWastedKResizing(int[] nums, int k) {
        int len=nums.length;
        int[] MAX=new int[len];
        int max=0;
        Deque<Integer> deque=new ArrayDeque<>();
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<len;i++){
            max=Math.max(max,nums[i]);
            MAX[i]=max;
            if (set.contains(max)) continue;
            deque.addFirst(max);
            set.add(max);
            while (deque.size()>k+1) deque.pollLast();
        }
        int ans=0;
        if (!deque.isEmpty()) max=deque.pollLast();
        else max=MAX[len-1];
        for (int num : nums) {
            if (num > max) {
                if (!deque.isEmpty()) {
                    max = deque.pollLast();
                }
            }
            ans += max - num;
        }
        return ans;
    }

    public static void main(String[] args) {
        // int[] nums={10,20,15,30,20};
        // int[] nums={10,20,30};
        // int[] nums={10,20};
        int[] nums={13,46,42,45,35};
        System.out.println(minSpaceWastedKResizing(nums,4));
    }
}
