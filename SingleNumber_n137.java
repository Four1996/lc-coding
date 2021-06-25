package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年04月18日 10:06 上午
 */
public class SingleNumber_n137 {
    public int singleNumber(int[] nums){
        Arrays.sort(nums);
        int len=nums.length;
        if (len==1) return nums[0];
        HashMap<Integer,Integer> hashmap=new HashMap<>();
        hashmap.put(0,nums[0]);
        int cur=1;
        for (int i=1;i<len;i++){
            if (!hashmap.containsValue(nums[i])){
                if (cur==1) return hashmap.get(i-1);
                cur=1;
                hashmap.clear();
                hashmap.put(i,nums[i]);
            }else{
                cur++;
            }
        }
        return nums[len-1];
    }

    public static void main(String[] args) {
        int[] nums={4,1,2,1,2};
        SingleNumber_n137 singleNumber_n136=new SingleNumber_n137();
        System.out.println(singleNumber_n136.singleNumber(nums));
    }
}
