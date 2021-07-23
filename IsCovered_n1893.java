package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: first
 * @description: 检查是否区域内所有证书都被覆盖
 * @author: panhao
 * @date: 2021-07-23 14:22
 **/
public class IsCovered_n1893 {
    public static boolean isCovered(int[][] ranges, int left, int right) {
        int len=ranges.length;
        HashSet<Integer> set=new HashSet<>();
        while (left<=right){
            set.add(left++);
        }
        for (int i=0;i<len;i++){
            int x=ranges[i][0];
            int y=ranges[i][1];
            while (x<=y){
                set.remove(x);
                x++;
            }
        }
        return set.isEmpty();
    }

    public static void main(String[] args) {
        int[][] nums={
                {1,2},{3,4},{5,6}
        };
        System.out.println(isCovered(nums,2,5));
    }
}
