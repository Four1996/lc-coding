package leetcode.classic;

import java.util.PriorityQueue;

/**
 * @program: first
 * @description: 栈排序
 * @author: panhao
 * @date: 2021-06-24 10:42
 **/
public class SortedStack_n2045 {
    PriorityQueue<Integer> queue;
    public SortedStack_n2045() {
        queue=new PriorityQueue<>();
    }

    public void push(int val) {
        queue.add(val);
    }

    public void pop() {
        queue.poll();
    }

    public int peek() {
        if (queue.isEmpty()) return -1;
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
