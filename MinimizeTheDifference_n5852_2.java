package leetcode;

import java.util.Arrays;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-08-22 10:53
 **/

public class MinimizeTheDifference_n5852_2 {
    int ans = Integer.MAX_VALUE;
    int row, col;
    public int minimizeTheDifference(int[][] mat, int target) {
        row = mat.length;
        col = mat[0].length;



        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {
                // {7,8,9,4,8,5,8,9},
                // {9,6,8,8,6,10,9,8},
                // {8,4,6,3,10,5,8,5},
                // {5,9,9,9,9,10,10,7},
                // {5,4,8,9,6,10,2,6},
                // {1,4,2,1,10,1,5,10}
                {1,2,9,8,7}
        };
        System.out.println(new MinimizeTheDifference_n5852_2().minimizeTheDifference(mat, 6));
    }
}
