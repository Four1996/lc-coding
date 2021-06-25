package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author panhao
 * @date 2021年04月13日 10:50 上午
 */
public class RemoveElement_n27 {
    public static int removeElement(int[] nums,int val){
        int len=nums.length;
        if (len==0) return 0;
        int count=0;
        for (int i=0;i<len;i++){
            if (nums[i]==val) {
                count++;
                nums[i]=-1;
            }
        }
//        Comparator cmp=new CMP();
        Arrays.sort(nums);
        for (int j=0;j<len-count;j++){
            nums[j]=nums[j+count];
        }
        return len-count;
    }
//    static class CMP implements Comparator<Integer>{
//        @Override
//        public int compare(Integer a, Integer b) {
//            return b-a;
//        }
//    }

    public static void main(String[] args) {
        int[] nums={0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums,2));
    }
}
