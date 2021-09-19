package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-19 10:34
 **/
public class sumOfBeauties_5876 {
    public int sumOfBeauties(int[] nums) {
        int ans = 0;
        int len = nums.length;
        int[] minMark = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            if (i == len - 2) {
                minMark[i] = nums[i + 1];
            } else {
                minMark[i] = Math.min(nums[i + 1], minMark[i + 1]);
            }
        }
        int[] maxMark = new int[len];
        for (int i = 1; i < len; i++) {
            if (i == 1) {
                maxMark[i] = nums[i - 1];
            } else {
                maxMark[i] = Math.max(nums[i - 1], maxMark[i - 1]);
            }
        }
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] < minMark[i] && nums[i] > maxMark[i]) {
                ans += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                ans += 1;
            } else {
                ans += 0;
            }
        }
        return ans;
    }
}
