package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author panhao
 * @date 2021年06月02日 4:27 下午
 */
public class SubarraysDivByK_n974 {
    public static int subarraysDivByK(int[] nums, int k) {
        int len = nums.length;
        int sum=0;
        int ans = 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int i = 0; i <len; i++) {
            sum+=nums[i];
            int rem=(sum%k+k)%k;
            if (map.containsKey(rem)){
                ans+=map.get(rem);
                map.put(rem,map.get(rem)+1);
            }else{
                map.put(rem,1);
            }
        }
        return ans;
//        Map<Integer, Integer> record = new HashMap<Integer, Integer>();
//        record.put(0, 1);
//        int sum = 0, ans = 0;
//        for (int elem : nums) {
//            sum += elem;
//            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
//            int modulus = (sum % k + k) % k;
//            int same = record.getOrDefault(modulus, 0);
//            ans += same;
//            record.put(modulus, same + 1);
//        }
//        return ans;
    }

    public static void main(String[] args) {
        int[] nums={4,5,0,-2,-3,1};
        System.out.println(subarraysDivByK(nums,5));
    }
}
