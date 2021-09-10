package leetcode.binarySearch;

/**
 * @program: first
 * @description: 排序树组中只出现一次的数字
 * @author: panhao
 * @date: 2021-09-10 21:47
 **/
public class singleNonDuplicate_n2184 {
    public static int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right + 1) >> 1;
            if (mid % 2 == 0) {
                if (mid>0&&nums[mid] == nums[mid - 1]) {
                    right = mid - 2;
                } else if (mid<len-1&&nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    return nums[mid];
                }
            } else {
                if (mid<len-1&&nums[mid] == nums[mid + 1]) {
                    right = mid - 1;
                } else if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    return nums[mid];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(singleNonDuplicate(nums));
    }
}
