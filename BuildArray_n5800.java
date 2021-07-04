package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-04 10:30
 **/
public class BuildArray_n5800 {
    public int[] buildArray(int[] nums) {
        int len=nums.length;
        int[] ans=new int[len];
        for (int i=0;i<len;i++){
            ans[i]=nums[nums[i]];
        }
        return ans;
    }
}
