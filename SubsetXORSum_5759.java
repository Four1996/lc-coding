package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panhao
 * @date 2021年05月16日 10:30 上午
 */
public class SubsetXORSum_5759 {
    public static int subsetXORSum(int[] nums) {
        int count = (int)Math.pow(2,nums.length);
        int ans=0;
        for(int i=1;i<count;i++){
            int xorsub=0;
            int temp = i;
            int index = 0;
            while (temp!=0){
                if((temp&1)==1){
                    xorsub^=nums[index];
                }
                index++;
                temp = temp >>1;
            }
            ans+=xorsub;
        }
        return ans;
    }

    public static List getSubArrays(int[] nums){
        int count = (int)Math.pow(2,nums.length);
        List<ArrayList<Integer>> arrays = new ArrayList<>();
        int ans=0;
        for(int i=1;i<count;i++){
            List<Integer> subarray = new ArrayList<Integer>();
            int xorsub=0;
            int temp = i;
            int index = 0;
            while (temp!=0){
                if((temp&1)==1){
                    xorsub^=nums[index];
                    subarray.add(nums[index]);
                }
                index++;
                temp = temp >>1;
            }
            ans+=xorsub;
            arrays.add((ArrayList<Integer>) subarray);
        }
        return arrays;
    }
    public static void main(String[] args) {
        int[] nums = {5,1,6};
//        List<ArrayList<Integer>> arrays = getSubArrays(nums);
//        for(int i=0;i<arrays.size();i++){
//            ArrayList<Integer> sub = arrays.get(i);
//            for(int j=0;j<sub.size();j++){
//                System.out.print(sub.get(j)+"  ");
//            }
//            System.out.println();
//        }
        System.out.println(subsetXORSum(nums));

    }
}
