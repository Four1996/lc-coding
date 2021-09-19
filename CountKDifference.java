package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-18 22:30
 **/
public class CountKDifference {
    public int countKDifference(int[] nums, int k) {
        int len=nums.length;
        int ans=0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (Math.abs(nums[i]-nums[j])==k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
