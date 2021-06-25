package leetcode;

import java.util.Arrays;

public class DominanIndex_n747 {
    public static int dominanIndex(int[] nums){
        int len=nums.length;
        int max=nums[0];
        for (int i=1;i<len;i++){
            if (nums[i]>=max){
                max=nums[i];
            }
        }
        int tag=-1;
        boolean result=true;
        if (max==0) return -1;
        for(int i=0;i<len;i++){
            if (nums[i]!=0){
                if (max/nums[i]<2&&max!=nums[i]){
                    result=false;
                    break;
                }
                if (max/nums[i]==1){
                    tag=i;
                }
            }
        }
        if (result==true){
            return tag;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(dominanIndex(nums));

    }
}
