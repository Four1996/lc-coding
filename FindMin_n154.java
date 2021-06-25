package leetcode;

/**
 * @author panhao
 * @date 2021年04月09日 8:47 上午
 */
public class FindMin_n154 {
    public static int findMin(int[] nums){
        int len=nums.length;
        if (len==1) return nums[0];
        int left=0,right=len-1;
        boolean judge_right=false,judge_left=false;
        if (nums[left]==nums[right]){
            judge_right=true;
            while (nums[left]==nums[right]&&left<right){
                right--;
            }
            right++;
        }
//        if (preXOR[left]==preXOR[right]){
//            judge_left=true;
//            while (preXOR[left]==preXOR[right]&&left<right){
//                left++;
//            }
//        }
        if (judge_right) right--;
//        if (judge_left) left--;
        while (left<right){
            int mid=(left+right+1)/2;
            if (nums[mid]>=nums[0]){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        return right+1>=len?nums[0]:nums[right+1];
    }

    public static void main(String[] args) {
        int[] nums={3,1,3,3};
        System.out.println(findMin(nums));
    }
}
