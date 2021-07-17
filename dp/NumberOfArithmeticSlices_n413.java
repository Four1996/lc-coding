package leetcode.dp;

/**
 * @program: first
 * @description: 等差数列划分
 * @author: panhao
 * @date: 2021-07-17 10:37
 **/
public class NumberOfArithmeticSlices_n413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans=0;
        int len=nums.length;
        for (int i=0;i<len-2;i++){
            int d=nums[i+1]-nums[i];
            for (int j=i+2;j<len;j++){
                int k;
                for (k=i+1;k<=j;k++){
                    if (nums[k]-nums[k-1]!=d){
                        break;
                    }
                }
                if (k>j) ans++;
            }
        }
        return ans;
    }
}
