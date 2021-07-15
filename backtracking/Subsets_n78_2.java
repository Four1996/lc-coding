package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 子集
 * @author: panhao
 * @date: 2021-07-13 10:30
 **/
public class Subsets_n78_2 {

    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        int len=nums.length;
        ans=new ArrayList<>();
        path=new ArrayList<>();
        if (len==0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        dfs(nums,0);
        return ans;
    }
    void dfs(int[] nums,int idx){
        ans.add(new ArrayList<>(path));
        if (idx>=nums.length){
            return;
        }
        for (int i=idx;i<nums.length;i++){
            path.add(nums[i]);
            dfs(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
