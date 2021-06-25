package leetcode.swordoffer;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author panhao
 * @date 2021年06月05日 8:17 下午
 */
public class MaxQueue_n1987 {
    Deque<Integer> deque;
    PriorityQueue<Integer> queue;
    public MaxQueue_n1987() {
        deque=new LinkedList<>();
        queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }

    public int max_value() {
        if (deque.isEmpty()||queue.isEmpty()) return -1;
        return queue.peek();
    }

    public void push_back(int value) {
        deque.add(value);
        queue.add(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) return -1;
        Integer integer = deque.pollFirst();
        queue.remove(integer);
        return integer;
    }
}
