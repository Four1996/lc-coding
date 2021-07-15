package leetcode.backtracking;


import java.util.*;

/**
 * @author panhao
 * @date 2021年03月31日 9:11 上午
 */
public class SubsetsWithDup_n90_2 {
    List<Integer> path;
    Set<List<Integer>> ans;
    public  List<List<Integer>> subsetsWithDup(int[] nums) {
        int len=nums.length;
        if (len<1) return null;
        ans=new HashSet<>();
        path=new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0);
        return new ArrayList<>(ans);
    }
    void dfs(int[] nums,int idx) {
        ans.add(new ArrayList<>(path));
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums,i+1);
            path.remove(path.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        System.out.println(new SubsetsWithDup_n90_2().subsetsWithDup(nums));

    }
}
