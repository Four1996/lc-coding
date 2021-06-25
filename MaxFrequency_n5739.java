package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月25日 10:40 上午
 */
public class MaxFrequency_n5739 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0, ans =1,total=0;
        for(int i=1;i<n;i++){
            total+=(nums[i]-nums[i-1])*(i-l);
            while(total>k){
                total-=nums[i]-nums[l];
                l++;
            }
            ans =Math.max(ans,i-l+1);
        }
        return ans;

    }

    public static void main(String[] args) {
        MaxFrequency_n5739 m=new MaxFrequency_n5739();
        int[] nums={1,2,4,6};
        System.out.println(m.maxFrequency(nums,5));
    }
}
