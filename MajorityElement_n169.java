package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author panhao
 * @date 2021年05月05日 9:06 下午
 */
public class MajorityElement_n169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                int n=map.get(nums[i]);
                map.put(nums[i],n+1);
            } else{
                map.put(nums[i],1);
            }
        }
        int ans=0,max=0;
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if (max<entry.getValue()){
                ans=entry.getKey();
                max=entry.getValue();
            }
        }
        return ans;
    }

}
