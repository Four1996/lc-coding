package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author panhao
 * @date 2021年06月13日 4:58 下午
 */
public class MergeTriplets_n1897 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int max1=0,max2=0,max3=0;
        for(int[] triplet:triplets){
            // 舍弃最大元素超过目标数组的三元组
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                max1 = Math.max(max1,triplet[0]);
                max2 = Math.max(max2,triplet[1]);
                max3 = Math.max(max3,triplet[2]);
            }
        }
        return max1 == target[0] && max2 == target[1] && max3 == target[2];
    }
}
