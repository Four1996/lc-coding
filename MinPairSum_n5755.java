package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年05月29日 10:34 下午
 */
public class MinPairSum_n5755 {
    public int minPairSum(int[] nums) {

        int len=nums.length;
        Arrays.sort(nums);
        int max=0;
        int left=0,right=nums.length-1;
        int[] sum=new int[len/2];
        int i=0;
        while (left<right){
            sum[i]=nums[left]+nums[right];
            max=Math.max(sum[i],max);
            i++;
            left++;
            right--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={3,5,2,3};
        System.out.println(new MinPairSum_n5755().minPairSum(nums));
    }
}
