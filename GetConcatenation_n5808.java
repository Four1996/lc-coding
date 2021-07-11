package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-11 10:30
 **/
public class GetConcatenation_n5808 {
    public int[] getConcatenation(int[] nums) {
        int len=nums.length;
        int[] ans=new int[len*2];
        for (int i=0;i<ans.length;i++){
            ans[i]=nums[i%len];
        }
        return ans;
    }
}
