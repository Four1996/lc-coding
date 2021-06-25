package leetcode;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author panhao
 * @date 2021年04月17日 8:40 下午
 */
public class ContainsNearbyDuplicate_n219 {
    public boolean containsNearbyDuplicate(int[] nums,int k){
        int len=nums.length;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i<len;i++){
            if (hashMap.containsKey(nums[i])){
                int a=hashMap.get(nums[i]);
                if (i-a<=k) return true;
            }
            hashMap.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1,2,3};
        ContainsNearbyDuplicate_n219 containsNearbyDuplicate_n219=new ContainsNearbyDuplicate_n219();
        System.out.println(containsNearbyDuplicate_n219.containsNearbyDuplicate(nums,2));
    }
}
