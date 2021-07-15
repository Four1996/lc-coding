package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 子集
 * @author: panhao
 * @date: 2021-07-13 10:30
 **/
public class Subsets_n78_3 {

    public static List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (len == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        for (int mask = 0; mask < (1 << len); mask++) {
            path.clear();
            for (int i = 0; i < len; i++) {
                if ((mask & (1 << i)) != 0) {
                    path.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(path));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(subsets(nums));
    }
}
