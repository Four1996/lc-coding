package leetcode;

/**
 * @author panhao
 * @date 2021年04月15日 10:58 上午
 */
public class MaxSubArray_n53 {
    public int maxSubArray(int[] nums){
        int len=nums.length;
        if(len==1) return nums[0];
        int max=nums[0],pre=nums[0],cur;
        for (int i=1;i<len;i++){
            cur=Math.max(nums[i]+pre,nums[i]);
            max=cur>max?cur:max;
            pre=cur;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray_n53 maxSubArray_n53=new MaxSubArray_n53();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray_n53.maxSubArray(nums));
    }
}
