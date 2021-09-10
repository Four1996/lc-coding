package leetcode.binarySearch;

/**
 * @program: first
 * @description: 查找插入位置
 * @author: panhao
 * @date: 2021-09-10 21:02
 **/
public class searchInsert_n2182 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        if (nums[right] < target) {
            return len;
        }
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
