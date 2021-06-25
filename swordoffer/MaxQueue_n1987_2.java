package leetcode.swordoffer;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author panhao
 * @date 2021年06月05日 8:17 下午
 */
public class MaxQueue_n1987_2 {
    Deque<Integer> deque;
    Deque<Integer> maxDeque;
    public MaxQueue_n1987_2() {
        deque=new LinkedList<>();
        maxDeque=new LinkedList<>();
    }

    public int max_value() {
        if (maxDeque.isEmpty()) return -1;
        return maxDeque.peekFirst();
    }

    public void push_back(int value) {
        deque.addLast(value);
        while (!maxDeque.isEmpty()&&maxDeque.peekLast()<value) maxDeque.removeLast();
        maxDeque.addLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) return -1;
        Integer integer = deque.pollFirst();
        if(maxDeque.peekFirst().equals(integer)) maxDeque.removeFirst();
        return integer;
    }
}
