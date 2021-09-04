package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @program: first
 * @description: 最大矩形
 * @author: panhao
 * @date: 2021-09-04 11:10
 **/
public class MaximalRectangle_n85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int len = matrix[0].length;
        int[] leftLow = new int[len];
        int[] rightLow = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] heights = new int[len];
        int ans = 0;
        for (char[] chars : matrix) {
            Arrays.fill(leftLow, -1);
            Arrays.fill(rightLow, len);
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
}
