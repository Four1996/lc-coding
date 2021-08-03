package leetcode.double_pointer;

/**
 * @program: first
 * @description: 最短无序连续子数组
 * @author: panhao
 * @date: 2021-08-03 09:03
 **/
public class FindUnsortedSubarray_n581_2 {
    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right && nums[left] <= nums[left + 1]) left++;
        while (left < right && nums[right] >= nums[right - 1]) right--;
        int min = nums[left], max = nums[right];
        int l_min = left, r_max = right;
        for (int i = l_min; i <= r_max; i++) {
            if (nums[i] < min) {
                while (left >= 0 && nums[i] < nums[left]) left--;
                min = left >= 0 ? nums[left] : Integer.MIN_VALUE;
            }
            if (nums[i] > max) {
                while (right < len && nums[i] > nums[right]) right++;
                max = right < len ? nums[right] : Integer.MAX_VALUE;
            }
        }
        return left == right ? 0 : (right - 1) - (left + 1) + 1;
    }

    public static void main(String[] args) {
        int[] nums={1,3,2,4,5};
        System.out.println(findUnsortedSubarray(nums));
    }
}
