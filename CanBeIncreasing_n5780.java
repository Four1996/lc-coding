package leetcode;

import java.util.HashSet;
import java.util.Stack;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-06-26 22:30
 **/
public class CanBeIncreasing_n5780 {
    public static boolean canBeIncreasing(int[] nums) {
        int len=nums.length;
        Stack stack=new Stack();
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                if (i==j) continue;
                if (stack.isEmpty()) stack.push(nums[j]);
                else{
                    int n= (int) stack.peek();
                    if (nums[j]>n) stack.push(nums[j]);
                    else{
                        break;
                    }
                }
            }
            if (stack.size()==len-1) return true;
            else{
                stack.clear();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={2,3,1,2};
        System.out.println(canBeIncreasing(nums));
    }
}
