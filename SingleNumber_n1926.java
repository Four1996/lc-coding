package leetcode;

import java.util.HashSet;

/**
 * @author panhao
 * @date 2021年04月18日 10:06 上午
 */
public class SingleNumber_n1926 {
    public int[] singleNumber(int[] nums){

        int len=nums.length;
        if (len==2) return nums;
        int[] ans=new int[2];
        HashSet<Integer> hashSet=new HashSet<>();
        hashSet.add(nums[0]);
        for (int i=1;i<len;i++){
            if (hashSet.contains(nums[i])) hashSet.remove(nums[i]);
            else hashSet.add(nums[i]);
        }
        int j=0;
        for (Integer e:hashSet){
            ans[j]=e;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,2,1,3,2,5};
        SingleNumber_n1926 singleNumber_n136=new SingleNumber_n1926();
        System.out.println(singleNumber_n136.singleNumber(nums));
    }
}
