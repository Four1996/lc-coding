package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: first
 * @description: 子集
 * @author: panhao
 * @date: 2021-07-13 10:30
 **/
public class Subsets_n78 {


    public List<List<Integer>> subsets(int[] nums) {
        int len=nums.length;
        if (len==0) return new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> temp=new ArrayList<>();
            for (List<Integer> list : ans) {
                List<Integer> sub=new ArrayList<>(list);
                sub.add(num);
                temp.add(sub);
            }
            ans.addAll(temp);
        }
        return ans;
    }
}
