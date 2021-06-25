package leetcode;

/**
 * @author panhao
 * @date 2021年05月08日 9:04 下午
 */
public class RunningSum_n1480 {
    public static int[] runningSum(int[] nums) {
        int [] ans=new int[nums.length];
        for (int i=0;i<nums.length;++i){
            if (i==0) ans[i]=nums[i];
            else{
                ans[i]=ans[i-1]+nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums={1,2,3,4};
        System.out.println(runningSum(nums));
    }
}
