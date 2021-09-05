package leetcode.math;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 计算器
 * @author: panhao
 * @date: 2021-09-04 21:04
 **/
public class Calculate_n2309_2 {
    public static int calculate(String s) {
        int len = s.length();
        int preChar = '+';
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                int num = 0;
                while (i < len && (ch = s.charAt(i)) >= '0' && ch <= '9') {
                    num = num * 10 + ch - '0';
                    i++;
                }
                i--;
                if (preChar == '*') {
                    deque.addFirst(num * deque.pollFirst());
                } else if (preChar == '/') {
                    deque.addFirst(deque.pollFirst() / num);
                } else if (preChar == '+') {
                    deque.addFirst(num);
                } else if (preChar == '-') {
                    deque.addFirst(-num);
                }
            } else {
                preChar = ch;
            }
        }
        int sum = 0;
        while (!deque.isEmpty()) {
            sum += deque.pollFirst();
        }
        return sum;
    }

    public static void main(String[] args) {
        String s=" 3/2 ";
        System.out.println(calculate(s));
    }
}
