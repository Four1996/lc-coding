package leetcode;

/**
 * @program: first
 * @description: 寻找峰值
 * @author: panhao
 * @date: 2021-07-04 18:32
 **/
public class FindPeakElement_n162 {
    public int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]>nums[mid+1]) right=mid;
            else left=mid+1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums={1,3,2,1};
        System.out.println(new FindPeakElement_n162().findPeakElement(nums));
    }
}
