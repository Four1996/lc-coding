package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author panhao
 * @date 2021年04月18日 10:06 上午
 */
public class SingleNumber_n136_2 {
    public int singleNumber(int[] nums){
        if (nums.length==1) return nums[0];
        int ans=nums[0];
        for (int i=1;i<nums.length;i++){
            ans=ans^nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        SingleNumber_n136_2 singleNumber_n136=new SingleNumber_n136_2();
        System.out.println(singleNumber_n136.singleNumber(nums));
    }
}
