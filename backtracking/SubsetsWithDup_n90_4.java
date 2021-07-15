package leetcode.backtracking;


import java.util.*;

/**
 * @author panhao
 * @date 2021年03月31日 9:11 上午
 */
public class SubsetsWithDup_n90_4 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        if (len < 1) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        ans.add(new ArrayList<>(Arrays.asList(nums[0])));
        int pre_len = 1;
        for (int i = 1; i < len; i++) {
            int size = ans.size();
            if (nums[i] != nums[i - 1]) pre_len = size;
            for (int j = size - pre_len; j < size; j++) {
                List<Integer> inner = new ArrayList<>(ans.get(j));
                inner.add(nums[i]);
                ans.add(inner);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        System.out.println(new SubsetsWithDup_n90_4().subsetsWithDup(nums));
        int a = 3 & 1;
        System.out.println(Integer.toBinaryString(a));
    }
}
