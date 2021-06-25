package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author panhao
 * @date 2021年04月30日 10:34 上午
 */
public class FindDisappearedNumbers_448 {
    public static List<Integer> findDisappearedNumbers(int[] nums){
        int len=nums.length;
        int u=1;
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<len;){
            if (nums[i]==u){
                u++;
                i++;
            }else{
                if (nums[i]<u) i++;
                else{
                    list.add(u);
                    u++;
                }
            }
        }
        while (u<=len){
            list.add(u);
            u++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        for (int i:findDisappearedNumbers(nums)){
            System.out.println(i);
        }
    }
}
