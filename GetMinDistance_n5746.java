package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年05月02日 10:32 上午
 */
public class GetMinDistance_n5746 {
    public static int getMinDistance(int[] nums, int target, int start) {

        int len=nums.length;
        int cur;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<len;i++){
            if (nums[i]==target) {
                cur=i;
                min=min>Math.abs(cur-start)?Math.abs(cur-start):min;
            }
        }
        return min;

    }

    public static void main(String[] args) {
        int[] nums={1,1,1,1,1,1,1,1,1,1};
        System.out.println(getMinDistance(nums,1,9));
    }
}
