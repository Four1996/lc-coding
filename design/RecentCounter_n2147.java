package leetcode.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 最近请求次数
 * @author: panhao
 * @date: 2021-09-04 14:56
 **/
public class RecentCounter_n2147 {
    Deque<Integer> deque;

    public RecentCounter_n2147() {
        deque = new ArrayDeque<>();
    }

    public int ping(int t) {
        int min = t - 3000;
        deque.addFirst(t);
        while (!deque.isEmpty() && deque.peekLast() < min) {
            deque.pollLast();
        }
        return deque.size();
    }
}
