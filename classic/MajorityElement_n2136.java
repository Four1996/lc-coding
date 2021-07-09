package leetcode.classic;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: first
 * @description: 主要元素
 * @author: panhao
 * @date: 2021-07-09 09:34
 **/
public class MajorityElement_n2136 {
    public int majorityElement(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        boolean tag=false;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > len / 2) {
                ans = num;
                tag = true;
                break;
            }
        }
        return tag==true?ans:-1;
    }

    public static void main(String[] args) {
        int[] nums={3,3,4};
        System.out.println(new MajorityElement_n2136().majorityElement(nums));
    }
}
