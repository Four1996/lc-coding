package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月30日 9:21 上午
 */
public class MissingNumber_n268 {
    public int missingNumber(int[] nums){

        Arrays.sort(nums);
        int len=nums.length;
        if (len==1) return nums[0]==0?1:--nums[0];
        if(nums[0]!=0) return 0;
        int ans=nums[0];
        ans++;
        for (int i=1;i<len;i++){
            if (nums[i]!=ans) return ans;
            ans++;
        }
        return ans;
    }
}
