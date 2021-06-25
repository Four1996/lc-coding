package leetcode;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年04月17日 9:09 下午
 */
public class FindDuplicate_n287 {
    public int findDuplicate(int[] nums){
        HashMap<Integer, Integer> hashMap=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (hashMap.containsKey(nums[i])) return nums[i];
            else hashMap.put(nums[i],i);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums={3,1};
        FindDuplicate_n287 findDuplicate_n287=new FindDuplicate_n287();
        System.out.println(findDuplicate_n287.findDuplicate(nums));
    }
}
