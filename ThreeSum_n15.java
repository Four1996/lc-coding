package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月12日 5:36 下午
 */
public class ThreeSum_n15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int len= nums.length;
        Arrays.sort(nums);
        for (int i=0;i<len;i++){
            if (nums[i]>0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int left=i+1,right=len-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if (sum==0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right&&nums[left]==nums[left+1]) left++;
                    while (left<right&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }else if (sum<0) left++;
                else if(sum>0) right--;
            }
        }
        return list;
    }
}
