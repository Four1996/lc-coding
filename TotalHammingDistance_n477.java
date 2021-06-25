package leetcode;

/**
 * @author panhao
 * @date 2021年05月28日 9:32 上午
 */
public class TotalHammingDistance_n477 {
    public int totalHammingDistance(int[] nums) {
        int ans=0,len=nums.length;
        for (int i=0;i<32;i++) {
            int c=0;
            for (int num : nums) {
                c+=num>>i&1;
            }
            ans+=c*(len-c);
        }
        return ans;
    }
}
