package leetcode.simulate;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 有效的括号字符串
 * @author: panhao
 * @date: 2021-09-12 10:07
 **/
public class checkValidString_n678 {
    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ')') {
                if (left.isEmpty() && star.isEmpty()) {
                    return false;
                } else if (!left.isEmpty()) {
                    left.pollFirst();
                } else {
                    star.pollFirst();
                }
            } else if (c == '(') {
                left.addFirst(i);
            } else {
                star.addFirst(i);
            }
        }
        while (!left.isEmpty()) {
            if (star.isEmpty()) {
                return false;
            } else {
                if (left.peekFirst() > star.peekFirst()) {
                    return false;
                } else {
                    left.pollFirst();
                    star.pollFirst();
                }
            }
        }
        return true;
    }
}
