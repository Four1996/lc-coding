package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author panhao
 * @date 2021年04月17日 8:40 下午
 */
public class ContainsNearbyDuplicate_n219_2 {
    public boolean containsNearbyDuplicate(int[] nums,int k){
        int len=nums.length;
        HashSet<Integer> hashSet=new HashSet<>();
        int left=0,right=k;
        if(k>len-1) right=len-1;
        for (int i=left;i<=right;i++){
            if (hashSet.contains(nums[i])){
                return true;
            }
            hashSet.add(nums[i]);
        }
        ++left;++right;
        while(right<len){
            hashSet.remove(nums[left-1]);
            if (hashSet.contains(nums[right])){
                return true;
            }
            hashSet.add(nums[right]);
            left++;right++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        ContainsNearbyDuplicate_n219_2 containsNearbyDuplicate_n219=new ContainsNearbyDuplicate_n219_2();
        System.out.println(containsNearbyDuplicate_n219.containsNearbyDuplicate(nums,3));
    }
}
