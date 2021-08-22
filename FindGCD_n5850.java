package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-22 10:30
 **/
public class FindGCD_n5850 {
    public int findGCD(int[] nums) {
        int ans=1;
        int len=nums.length;
        Arrays.sort(nums);
        int min=nums[0];
        int max=nums[len-1];
        if (min==0||max==0){
            return min==0?max:min;
        }
        for ( int i = 2; i <= min && i <= max;i++){
            if(min % i == 0 && max % i == 0){
                ans = i;
            }
        }
        return ans;
    }
}
