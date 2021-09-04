package leetcode.stack;

import javafx.scene.chart.Axis;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @program: first
 * @description: 矩阵中最大的矩形
 * @author: panhao
 * @date: 2021-09-04 10:19
 **/
public class MaximalRectangle_n2145 {
    public static int maximalRectangle(String[] matrix) {
        if (matrix.length==0){
            return 0;
        }
        int len = matrix[0].length();
        int[] leftLow = new int[len];
        int[] rightLow = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] heights = new int[len];
        int ans = 0;
        for (String s : matrix) {
            Arrays.fill(leftLow, -1);
            Arrays.fill(rightLow, len);
            char[] chars = s.toCharArray();
            for (int i = 0; i < len; i++) {
                if (chars[i] == '1') {
                    heights[i] += 1;
                } else {
                    heights[i] = 0;
                }
            }
            for (int i = 0; i < len; i++) {
                if (deque.isEmpty() || heights[deque.peekFirst()] <= heights[i]) {
                    deque.addFirst(i);
                } else {
                    while (!deque.isEmpty() && heights[deque.peekFirst()] > heights[i]) {
                        rightLow[deque.peekFirst()] = i;
                        deque.pollFirst();
                    }
                    deque.addFirst(i);
                }
            }
            deque.clear();
            for (int i = len - 1; i >= 0; i--) {
                if (deque.isEmpty() || heights[deque.peekFirst()] <= heights[i]) {
                    deque.addFirst(i);
                } else {
                    while (!deque.isEmpty() && heights[deque.peekFirst()] > heights[i]) {
                        leftLow[deque.peekFirst()] = i;
                        deque.pollFirst();
                    }
                    deque.addFirst(i);
                }
            }
            for (int i = 0; i < len; i++) {
                int area = (rightLow[i] - leftLow[i] - 1) * heights[i];
                ans = Math.max(area, ans);
            }
            deque.clear();
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] nums={
                "0110111111111111110","1011111111111111111","1101111111110111111","1111111111111011111",
                "1111111111111101111","1110111011111111101","1011111111111101111","1111111111111110110",
                "0011111111111110111","1101111111011111111","1111111110111111111","0110111011111111111",
                "1111011111111101111","1111111111111111111","1111111111111111111","1111111111111111101",
                "1111111101101101111","1111110111111110111"
        };
        System.out.println(maximalRectangle(nums));
    }
}
