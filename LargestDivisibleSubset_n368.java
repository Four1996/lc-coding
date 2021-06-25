package leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author panhao
 * @date 2021年04月23日 2:17 下午
 */
public class LargestDivisibleSubset_n368 {
    public List<Integer> largestDivisibleSubset(int[] nums){
        Arrays.sort(nums);
        int len=nums.length;
        List<Integer> ans=new ArrayList<>();
        int[] dp=new int[len];
        Arrays.fill(dp,1);
        int max=0;//记录最大dp值的下标。
        for (int i=1;i<len;i++){
            int tem =1;
            for (int j=i-1;j>=0;){
                if (nums[i]%nums[j]==0) tem = tem >dp[j]+1? tem :dp[j]+1;
                j--;
            }
            dp[i]= tem ==1?1: tem ;
            max=dp[i]>dp[max]?i:max;
        }
        int u=dp[max];
        while (u>=1){
            ans.add(nums[max]);
            u--;
            if (u==0) break;
            for (int i=max;i>=0;i--){
                if (dp[i]==u&&nums[max]%nums[i]==0)
                {
                    max=i; break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        System.in.read();
        int[] nums={3,4,16,8};
        LargestDivisibleSubset_n368 l=new LargestDivisibleSubset_n368();
        for (int i:l.largestDivisibleSubset(nums)){
            System.out.println(i);
        }
        System.in.read();
    }
}
