package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年06月02日 9:16 上午
 */
public class CheckSubarraySum_523 {
    long[] preSum;
    int lowBit(int x){
        return x&(-x);
    }
    long query(int idx){
        int sum=0;
        while (idx>0){
            sum+=preSum[idx];
            idx-=lowBit(idx);
        }
        return sum;
    }
    void add(int idx,int val){
        while (idx<preSum.length){
            preSum[idx]+=val;
            idx+=lowBit(idx);
        }
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        preSum=new long[nums.length+1];
        for (int i=1;i<preSum.length;i++){
            add(i,nums[i-1]);
        }
        HashMap<Long,Integer> map=new HashMap<>();
        map.put(0L,-1);
        for (int i=0;i<nums.length;i++){
            long rem=query(i+1)%k;
            if (map.containsKey(rem)){
                int idx=map.get(rem);
                if (i-idx>=2) return true;
            }else{
                map.put(rem,i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={23,2,4,6,6};
        System.out.println(new CheckSubarraySum_523().checkSubarraySum(nums,7));
    }
}
