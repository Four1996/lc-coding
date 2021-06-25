package leetcode;

/**
 * @author panhao
 * @date 2021年04月14日 3:33 下午
 */
public class LengthOfLIS_n300_2_dp_binarysearch {
    public int lengthOfLIS(int[] nums){
        int len=nums.length;
        if (len<2) return len;
        int[] dp=new int[len];
        dp[0]=nums[0];
        int end=0;
        for (int i=1;i<len;i++){
            if (nums[i]>dp[end]) {
                dp[++end]=nums[i];
            } else{
                int left=0;
                int right=end;
                while(left<right){
                    int mid=left+(right-left)/2;
                    if (dp[mid]<nums[i]) left=mid+1;
                    else right=mid;
                }
                dp[left]=nums[i];
            }
        }
        return ++end;
    }

    public static void main(String[] args) {
        int[] nums={7,7,7,7,7,7,7};
        LengthOfLIS_n300_2_dp_binarysearch lengthOfLIS_n300_2_dp_binarysearch=new LengthOfLIS_n300_2_dp_binarysearch();
        System.out.println(lengthOfLIS_n300_2_dp_binarysearch.lengthOfLIS(nums));
    }
}
