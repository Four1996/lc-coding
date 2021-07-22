package leetcode.dp;


/**
 * @program: first
 * @description: 最长递增子序列
 * @author: panhao
 * @date: 2021-07-21 20:37
 **/
public class LengthOfLIS_n300_2 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i];
            } else {
                int left = 0, right = end;
                while (left < right) {
                    int mid = left + ((right - left) >> 1);
                    if (tail[mid] < nums[i]) left = mid + 1;
                    else right = mid;
                }
                tail[left] = nums[i];
            }
        }
        return ++end;
    }
}
