package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年04月18日 10:06 上午
 */
public class SingleNumber_n137_2 {
    public int singleNumber(int[] nums){
        int len=nums.length;
        int ans=0;
        for (int i=0;i<32;i++){
            int count=0;
            for (int j=0;j<len;j++){
                count+=(nums[j]>>i&1);
            }
            if (count%3==1) ans=ans|1<<i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={2,2,3,2};
        SingleNumber_n137_2 singleNumber_n136=new SingleNumber_n137_2();
        System.out.println(singleNumber_n136.singleNumber(nums));
    }
}
