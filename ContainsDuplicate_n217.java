package leetcode;

import java.util.*;

/**
 * @author panhao
 * @date 2021年04月17日 8:17 下午
 */
public class ContainsDuplicate_n217 {
    public boolean containsDuplicate(int[] nums){
//        Set<Integer> set=new HashSet();
//        int len=preXOR.length;
//        if (len<2) return false;
//        for (int i=0;i<len;i++){
//            if (set.isEmpty()) set.add(preXOR[i]);
//            else{
//                if (set.contains(preXOR[i])) return true;
//                set.add(preXOR[i]);
//            }
//        }
//        return false;
        int len=nums.length;
        if (len<2) return false;
        Arrays.sort(nums);
        int u=nums[0];
        for (int i=1;i<len;i++){
            if (u==nums[i]) return true;
            u=nums[i];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        ContainsDuplicate_n217 containsDuplicate_n217=new ContainsDuplicate_n217();
        System.out.println(containsDuplicate_n217.containsDuplicate(nums));
    }
}
