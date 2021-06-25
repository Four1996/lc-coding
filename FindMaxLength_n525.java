package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年06月03日 9:15 上午
 */
public class FindMaxLength_n525 {
    public int findMaxLength(int[] nums) {
        int ans=0;
        int[] presum=new int[nums.length+1];

        for (int i=1;i<=nums.length;i++){
            if (nums[i-1]==0) nums[i-1]=-1;
            presum[i]=presum[i-1]+nums[i-1];
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for (int i=1;i<presum.length;i++){
            if (map.containsKey(presum[i])){
                int idx=map.get(presum[i]);
                ans=Math.max(i-idx-1,ans);
            }else{
                map.put(presum[i],i-1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={0,1,1,0,1,1,1,0,0,1,1,0,1,0,0,1};
        System.out.println(new FindMaxLength_n525().findMaxLength(nums));
    }
}
