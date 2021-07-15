package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: first
 * @description: 组合总和II
 * @author: panhao
 * @date: 2021-07-15 20:50
 **/
public class CombinationSum2_n40 {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[] vis;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        if (len < 1) return new ArrayList<>();
        vis = new boolean[len];
        ans = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return ans;
    }

    public void dfs(int[] candidates, int idx, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !vis[i - 1]) continue;
            if (target - candidates[i] < 0) break;
            path.add(candidates[i]);
            vis[i] = true;
            dfs(candidates, i + 1, target - candidates[i]);
            path.remove(path.size() - 1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 2, 1, 2};
        System.out.println(new CombinationSum2_n40().combinationSum2(nums, 5));
    }
}
