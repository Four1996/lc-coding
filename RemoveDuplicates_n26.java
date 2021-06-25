package leetcode;

/**
 * @author panhao
 * @date 2021年04月06日 10:55 上午
 */
public class RemoveDuplicates_n26 {
    public static int removeDuplicates(int[] nums) {
        return process(nums, 1);
    }
    static int process(int[] nums, int k) {
        int ans = 0;
        for (int x : nums) {
            if (ans < k || nums[ans - k] != x) {
                nums[ans] = x;
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
}
