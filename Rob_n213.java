package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月15日 9:32 上午
 */
public class Rob_n213 {
    public  int rob(int[] nums){
        int len=nums.length;
        if (len==0) return 0;
        if (len==1) return nums[0];
        int sum1,sum2;
        sum1=getsum(Arrays.copyOfRange(nums,1,len));
        sum2=getsum(Arrays.copyOfRange(nums,0,len-1));
        return Math.max(sum1,sum2);
    }
    public int getsum(int[] nums){
        int  len= nums.length;
        if (len==1) return nums[0];
        int pre=0,cur=0,tmp;
        for (int i=0;i<len;i++){
            tmp=cur;
            cur=Math.max(pre+nums[i],cur);
            pre=tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        Rob_n213 rob_n213=new Rob_n213();
        int[] nums={1,3,1,3,100};
        System.out.println(rob_n213.rob(nums));
    }
}
