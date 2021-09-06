package leetcode.binarySearch;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-06 09:34
 **/
public class search_n704 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
