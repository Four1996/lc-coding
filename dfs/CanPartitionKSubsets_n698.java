package leetcode.dfs;

import javax.smartcardio.ATR;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: first
 * @description: 划分为k个相等的子集
 * @author: panhao
 * @date: 2021-07-28 16:02
 **/
public class CanPartitionKSubsets_n698 {
    int target;
    boolean[] vis;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        target = sum / k;
        vis = new boolean[len];
        Arrays.sort(nums);
        return dfs(nums, 0, len - 1, k);
    }

    boolean dfs(int[] nums, int sum, int idx, int k) {
        if (k == 1) return true;
        if (sum == target) return dfs(nums, 0, nums.length - 1, k - 1);
        for (int i = idx; i >= 0; i--) {
            if (vis[i]) continue;
            if (sum + nums[i] > target) continue;
            vis[i] = true;
            if (dfs(nums, sum + nums[i], i - 1, k)) return true;
            vis[i] = false;
            while (i > 0 && nums[i - 1] == nums[i]) i--;
        }
        return false;
    }
}
