package leetcode.double_pointer;

import java.util.Arrays;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-06 10:20
 **/
public class nextPermutation_n31 {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int r = len - 1, l;
        while (r > 0 && nums[r] <= nums[r - 1]) {
            r--;
        }
        if (r == 0) {
            Arrays.sort(nums);
        } else {
            l = r - 1;
            while (r < len && nums[r] > nums[l]) {
                r++;
            }
            r--;
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r = len - 1;
            while (l < r) {
                int t = nums[r];
                nums[r] = nums[l];
                nums[l] = t;
                r--;
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={5,1,1};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
