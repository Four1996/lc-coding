package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 旋转图像
 * @author: panhao
 * @date: 2021-07-05 10:51
 **/
public class Rotate_n48 {
    public void rotate(int[][] matrix) {
        List<List<Integer>> list = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            List<Integer> list1 = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list1.add(matrix[i][j]);
            }
            list.add(list1);
        }
        int j = col - 1;
        for (List<Integer> integers : list) {
            int r = 0;
            for (Integer integer : integers) {
                matrix[r][j] = integer;
                r++;
            }
            j--;
        }
    }
}

