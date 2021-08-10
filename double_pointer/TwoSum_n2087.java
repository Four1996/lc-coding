package leetcode.double_pointer;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-10 15:02
 **/
public class TwoSum_n2087 {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int[] ans = new int[2];
        int left = 0, right = len - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum == target) {
                ans[0] = left;
                ans[1] = right;
                return ans;
            } else {
                left++;
            }
        }
        return ans;
    }
}
