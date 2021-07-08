package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description: 除自身以外数组的乘积
 * @author: panhao
 * @date: 2021-07-07 20:10
 **/
public class ProductExceptSelf_n238 {
    public static int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        if (len<2) return new int[0];
        int[] res=new int[len];
        res[0]=1;
        int temp=1;
        for (int i=1;i<len;i++) {
            res[i]=res[i-1]*nums[i-1];
        }
        for (int i=len-2;i>=0;i--){
            temp*=nums[i+1];
            res[i]*=temp;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }
}
