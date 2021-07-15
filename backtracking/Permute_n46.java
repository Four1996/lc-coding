package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 全排列
 * @author: panhao
 * @date: 2021-07-15 16:23
 **/
public class Permute_n46 {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[] vis;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        int len = nums.length;
        vis = new boolean[len];
        if (len < 1) return new ArrayList<>();
        getSub(nums);
        return ans;
    }

    public void getSub(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            path.add(nums[i]);
            vis[i] = true;
            getSub(nums);
            vis[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
