package leetcode.classic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: first
 * @description: 主要元素
 * @author: panhao
 * @date: 2021-07-09 09:34
 **/
public class MajorityElement_n2136_2 {
    public int majorityElement(int[] nums) {
        int most=0;
        int count=0;
        for (int num : nums) {
            if (count==0) {
                most=num;
                count++;
            } else{
                if (num==most) count++;
                else count--;
            }
        }
        count=0;
        for (int num : nums) {
            if (num==most) count++;
        }
        return count> nums.length/2?most:-1;
    }

    public static void main(String[] args) {
        int[] nums={3,3,4};
        System.out.println(new MajorityElement_n2136_2().majorityElement(nums));
    }
}
