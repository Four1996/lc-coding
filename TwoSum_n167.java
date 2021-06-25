package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月05日 7:59 下午
 */
public class TwoSum_n167 {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int[] ans=new int[2];
        for (int i=0;i<numbers.length;i++){
            int diff=target-numbers[i];
            if (hashMap.containsKey(diff)){
               ans[0]=hashMap.get(diff)+1;
               ans[1]=i+1;
            }else{
                hashMap.put(numbers[i],i);
            }
        }
        return ans;
    }
}
