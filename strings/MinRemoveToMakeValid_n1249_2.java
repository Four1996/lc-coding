package leetcode.strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: first
 * @description: 移除无效的括号
 * @author: panhao
 * @date: 2021-09-04 18:47
 **/
public class MinRemoveToMakeValid_n1249_2 {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == '(') {
                deque.addFirst(i);
                sb.append(c);
            } else if (c == ')') {
                if (!deque.isEmpty()) {
                    deque.pollFirst();
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        s = sb.toString();
        StringBuilder res = new StringBuilder();
        deque.clear();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                deque.addFirst(i);
                res.append(c);
            } else if (c == '(') {
                if (!deque.isEmpty()) {
                    deque.pollFirst();
                    res.append(c);
                }
            } else {
                res.append(c);
            }
        }
        return res.reverse().toString();
    }
}
