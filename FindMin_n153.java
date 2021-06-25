package leetcode;

/**
 * @author panhao
 * @date 2021年04月08日 9:13 上午
 */
public class FindMin_n153 {
    public static int findMin(int[] nums){
        int len=nums.length;
        if (len==1) return nums[0];
        int left=0,right=len-1;
        while(left<right){
            int mid=(left+right+1)/2;
            if (nums[mid]>=nums[0]){
                left=mid;
            }
            else{
                right=mid-1;
            }
        }
        return right+1<len?nums[right+1]:nums[0];
    }

    public static void main(String[] args) {
        int[] nums={2,1};
        System.out.println(findMin(nums));
    }
}
