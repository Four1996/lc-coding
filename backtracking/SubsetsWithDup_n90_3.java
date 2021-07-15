package leetcode.backtracking;


import java.util.*;

/**
 * @author panhao
 * @date 2021年03月31日 9:11 上午
 */
public class SubsetsWithDup_n90_3 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        if (len < 1) return null;
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        // 枚举000到111的8中可能。
        for (int i = 0; i < (1 << len); i++) {
            path.clear();
            for (int j = 0; j < len; j++) {
                // 检查每一位为1的位，若为1，对应将nums的对应位加入。
                if (((i >> j) & 1) == 1) path.add(nums[j]);
            }
            ans.add(new ArrayList<>(path));
        }
        return new ArrayList<>(ans);
    }


    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        System.out.println(new SubsetsWithDup_n90_3().subsetsWithDup(nums));
        int a=3&1;
        System.out.println(Integer.toBinaryString(a));
    }
}
