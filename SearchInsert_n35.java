package leetcode;

import org.w3c.dom.ls.LSOutput;

/**
 * @author panhao
 * @date 2021年04月13日 8:43 下午
 */
public class SearchInsert_n35 {
    public static int searchInsert(int[] nums,int target){
        int len=nums.length;
        int left=0,right=len-1,mid=0;
        if (len==1) return nums[0]==target?0:(target<nums[0]?0:1);
        if (target<nums[0]) return 0;
        if (target>nums[len-1]) return len;
        while(left<=right){
            mid=(left+right)/2;
            if (target==nums[mid]) return mid;
            if (target<nums[mid]) right=mid-1;
            if (target>nums[mid]) left=mid+1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        System.out.println(searchInsert(nums,4));
    }
}
