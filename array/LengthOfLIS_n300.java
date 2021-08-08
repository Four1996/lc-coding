package leetcode.array;

/**
 * @program: first
 * @description: 最长递增子序列
 * @author: panhao
 * @date: 2021-08-08 16:17
 **/
public class LengthOfLIS_n300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] tail = new int[len];
        int end = 0;
        for (int num : nums) {
            if (end == 0 || num > tail[end - 1]) {
                tail[end++] = num;
            } else {
                int left = 0, right = end;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (tail[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = num;
            }
        }
        return end;
    }
}
