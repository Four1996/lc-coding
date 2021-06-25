package leetcode;

import java.util.HashSet;

/**
 * @author panhao
 * @date 2021年04月18日 10:06 上午
 */
public class SingleNumber_n1926_2 {
    public int[] singleNumber(int[] nums){
        int ret=0;
        for (int i:nums){
            ret^=i;
        }
        int count=1;
        while ((count&ret)==0){
            count<<=1;
        }
        int a=0,b=0;
        for (int i:nums){
            if ((a&1)==0) a^=i;
            else b^=i;
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        int[] nums={1,2,1,3,2,5};
        SingleNumber_n1926_2 singleNumber_n136=new SingleNumber_n1926_2();
        System.out.println(singleNumber_n136.singleNumber(nums));
    }
}
