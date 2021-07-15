package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: first
 * @description: 全排列II
 * @author: panhao
 * @date: 2021-07-15 16:03
 **/
public class PermuteUnique_n47 {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        int len = nums.length;
        vis = new boolean[len];
        if (len < 1) return new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums);
        return ans;
    }

    void dfs(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            if (i>0&&nums[i]==nums[i-1]&&!vis[i-1]) continue;
            path.add(nums[i]);
            vis[i] = true;
            dfs(nums);
            vis[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(new PermuteUnique_n47().permuteUnique(nums));
    }
}
