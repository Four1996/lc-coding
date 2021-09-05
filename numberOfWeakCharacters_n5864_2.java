package leetcode;

import java.util.*;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-05 10:38
 **/
public class numberOfWeakCharacters_n5864_2 {

    public static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int ans = 0;
        int max = 0;
        for (int[] property : properties) {
            if (property[1] < max) {
                ans++;
            }
            max = Math.max(max, property[1]);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] nums={
                {5,5},{5,4},{6,3},{3,6}
        };
        System.out.println(numberOfWeakCharacters(nums));
    }
}
