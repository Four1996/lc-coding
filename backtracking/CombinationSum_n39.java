package leetcode.backtracking;

import java.util.*;

/**
 * @program: first
 * @description: 组合总和
 * @author: panhao
 * @date: 2021-07-15 19:23
 **/
public class CombinationSum_n39 {

    Set<List<Integer>> ans;
    List<Integer> path;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len < 1) return new ArrayList<>();
        ans = new HashSet<>();
        path = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return new ArrayList<>(ans);
    }

    public void dfs(int[] candidates, int target, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (target-candidates[i]<0) break;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        System.out.println(new CombinationSum_n39().combinationSum(nums, 8));
    }
}
