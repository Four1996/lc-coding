package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年05月19日 10:53 上午
 */
public class Exchange_n1925 {
    public int[] exchange(int[] nums) {
        int[] ans=new int[nums.length];
        int pre=0,post=nums.length-1;
        for (int i=0;i<nums.length;i++){
            if (nums[i]%2==0){
                ans[post]=nums[i];
                post--;
            }else{
                ans[pre]=nums[i];
                pre++;
            }
        }
        return ans;
    }
}
