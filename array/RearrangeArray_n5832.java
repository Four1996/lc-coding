package leetcode.array;

import java.util.Arrays;

/**
 * @program: first
 * @description: 构造元素不等于相邻元素平均值的数组
 * @author: panhao
 * @date: 2021-08-15 19:59
 **/
public class RearrangeArray_n5832 {
    public static int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 1; ) {
           int temp=nums[i];
           nums[i]=nums[i+1];
           nums[i+1]=temp;
           i+=2;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums={1,5,2,6,3,7,4,8};
        for (int i : rearrangeArray(nums)) {
            System.out.println(i);
        }
    }
}
