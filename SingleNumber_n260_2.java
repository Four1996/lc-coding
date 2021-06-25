package leetcode;

import java.util.HashSet;

/**
 * @author panhao
 * @date 2021年04月18日 10:06 上午
 */
public class SingleNumber_n260_2 {
    public int[] singleNumber(int[] nums){
        int len=nums.length;
        if (len==2) return nums;

        int n=nums[0];
        for (int i=1;i<len;i++){
            n=n^nums[i];
        }
        int count=1;
        while((count&n)==0){
//            count<<=1;
            count=count<<1;
        }
        int a=0,b=0;
        for (int i=0;i<len;i++){
            if ((count&nums[i])==0) a=a^nums[i];
            else b=b^nums[i];
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        int[] nums={1,2,1,3,2,5};
        SingleNumber_n260_2 singleNumber_n136=new SingleNumber_n260_2();
        System.out.println(singleNumber_n136.singleNumber(nums));
    }
}
