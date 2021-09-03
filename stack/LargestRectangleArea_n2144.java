package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @program: first
 * @description: 直方图最大矩形面积
 * @author: panhao
 * @date: 2021-09-03 21:10
 **/
public class LargestRectangleArea_n2144 {
    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }
        // 记录h[i]右边第一个比h[i]小的元素下标。
        int[] rightLow = new int[len];
        // 记录h[i]左边第一个比h[i]小的元素下标。
        int[] leftLow = new int[len];
        Arrays.fill(rightLow, len);
        Arrays.fill(leftLow, -1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (deque.isEmpty() || heights[i] >= heights[deque.peekFirst()]) {
                deque.addFirst(i);
            } else {
                while (!deque.isEmpty() && heights[i] < heights[deque.peekFirst()]) {
                    rightLow[deque.pollFirst()] = i;
                }
                deque.addFirst(i);
            }
        }
        deque.clear();
        for (int i = len - 1; i >= 0; i--) {
            if (deque.isEmpty() || heights[i] >= heights[deque.peekFirst()]) {
                deque.addFirst(i);
            } else {
                while (!deque.isEmpty() && heights[i] < heights[deque.peekFirst()]) {
                    leftLow[deque.pollFirst()] = i;
                }
                deque.addFirst(i);
            }
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int area = (rightLow[i] - leftLow[i] - 1) * heights[i];
            ans = Math.max(ans, area);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,1};
        System.out.println(largestRectangleArea(nums));
    }
}
