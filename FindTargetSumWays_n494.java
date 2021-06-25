package leetcode;

import javax.persistence.Id;

/**
 * @author panhao
 * @date 2021年06月07日 8:59 上午
 */
public class FindTargetSumWays_n494 {
    int ans = 0;
    int sum = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target);
        return ans;
    }

    void dfs(int[] nums, int idx, int target) {
        if (idx == nums.length) {
            if (sum == target) ans++;
            return;
        }
        sum += nums[idx];
        dfs(nums, idx + 1, target);
//        回溯
        sum -= nums[idx];
        sum -= nums[idx];
        dfs(nums, idx + 1, target);
//        回溯
        sum += nums[idx];
        return;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(new FindTargetSumWays_n494().findTargetSumWays(nums, 3));
    }
}
