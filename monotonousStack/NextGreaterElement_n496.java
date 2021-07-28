package leetcode.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @program: first
 * @description: 下一个更大元素I
 * @author: panhao
 * @date: 2021-07-28 18:16
 **/
public class NextGreaterElement_n496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : nums2) {
            if (deque.isEmpty()) deque.addFirst(num);
            else {
                while (!deque.isEmpty() && num > deque.peekFirst()) {
                    int n = deque.pollFirst();
                    map.put(n, num);
                }
                deque.addFirst(num);
            }
        }
        int[] ans = new int[l1];
        for (int i = 0; i < l1; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
