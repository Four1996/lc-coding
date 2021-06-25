package leetcode;

import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月07日 8:53 上午
 */
public class Search_n33 {
    public static boolean search(int[] nums ,int target){
        Arrays.sort(nums);
        int len=nums.length;
        if (len==0) return false;
        if (len==1) return nums[0]==target?true:false;
        int left=0,right=len-1,mid=-1;
        while(left<=right){
            mid=(left+right)/2;
            if (nums[mid]>target){
                right=mid-1;
            }
            if (nums[mid]<target){
                left=mid+1;
            }
            if (nums[mid]==target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,0,1,1,1};
        System.out.println(search(nums,0));
    }
}
