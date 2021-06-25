package leetcode;

/**
 * @author panhao
 * @date 2021年04月13日 9:27 下午
 */
public class Search_n704 {
    public int search(int[] nums,int target){
        int len=nums.length;
        if (len==0) return -1;
        int left=0,right=len-1,mid=0;
        while (left<=right){
            mid=(left+right)/2;
            if (nums[mid]==target) return mid;
            if (nums[mid]>target) right=mid-1;
            else left=mid+1;
        }
        return -1;
    }
}
