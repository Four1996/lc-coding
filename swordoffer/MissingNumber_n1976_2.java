package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年06月04日 8:37 下午
 */
public class MissingNumber_n1976_2 {
    public int missingNumber(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==mid) left=mid+1;
            else right=mid-1;
        }
        return left;
    }
}
