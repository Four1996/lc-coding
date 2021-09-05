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
public class MinRemoveToMakeValid_n1249 {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == '(') {
                deque.addFirst(i);
            }
            if (c == ')') {
                if (deque.isEmpty()) {
                    set.add(i);
                } else {
                    deque.pollFirst();
                }
            }
        }
        while (!deque.isEmpty()) {
            set.add(deque.pollFirst());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (!set.contains(i)) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
