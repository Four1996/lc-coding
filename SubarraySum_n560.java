package leetcode;

/**
 * @author panhao
 * @date 2021年05月29日 10:29 上午
 */
public class SubarraySum_n560 {
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        int len=nums.length;
        int[] presum=new int[len+1];
        for (int i=1;i<=len;i++){
            presum[i]=presum[i-1]+nums[i-1];
        }
        for (int i=1;i<=len;i++){
            for (int j=1;j<=i;j++){
                if (presum[i]-presum[j-1]==k) ans++;
            }
        }
        return ans;
    }
}
