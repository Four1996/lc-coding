package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月15日 7:21 下午
 */
public class NumArray_n303 {
    int[] presum;

    public NumArray_n303(int[] nums) {
        int len=nums.length;
        presum=new int[len+1];
        for (int i=1;i<presum.length;i++){
            presum[i]=presum[i-1]+nums[i-1];
        }
    }
    public int sumRange(int left,int right){
        return presum[right+1]-presum[left];
    }

    public static void main(String[] args) {
        int[] nums={-2,0,3,-5,2,-1};
        NumArray_n303 numArray_n303=new NumArray_n303(nums);
        System.out.println(numArray_n303.sumRange(2,5));
    }
}
