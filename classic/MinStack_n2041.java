package leetcode.classic;

import java.util.*;

/**
 * @program: first
 * @description: 栈的最小值
 * @author: panhao
 * @date: 2021-06-23 14:58
 **/
public class MinStack_n2041 {
    Deque deque;
    Deque min;
    public MinStack_n2041() {
        deque=new ArrayDeque();
        min=new ArrayDeque();
    }

    public void push(int x) {
        Object o = min.peekFirst();
        if (min.isEmpty()) min.addFirst(x);
        else {
            if (x<=(int)o) min.addFirst(x);
        }
        deque.addFirst(x);
    }

    public void pop() {
        Object o = deque.pollFirst();
        if (o.equals(min.peekFirst())){
            min.pollFirst();
        }
    }

    public int top() {
        return (int) deque.peekFirst();
    }

    public int getMin() {
        return (int) min.peekFirst();
    }
}
