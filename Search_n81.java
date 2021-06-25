package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author panhao
 * @date 2021年04月07日 8:59 上午
 */
public class Search_n81 {
    public static int search(int[] nums, int target) {
        int k = 0;
        int len = nums.length;
        if (len == 1) return nums[0] == target ? 0 : -1;
        int pre = nums[0];
        for (int i = 0; i < len; i++) {
            if (target == nums[i]) return i;
            if (nums[i] < pre) {
                k = i;
                break;
            }
            pre = nums[i];
        }
        int left = k, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            if (nums[mid] < target) left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 3));
    }
}
