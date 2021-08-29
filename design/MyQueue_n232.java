package leetcode.design;

import java.util.Stack;

/**
 * @program: first
 * @description: 用栈实现队列
 * @author: panhao
 * @date: 2021-08-28 21:51
 **/
public class MyQueue_n232 {
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue_n232() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!s2.isEmpty()){
            return s2.pop();
        }else{
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            if (s2.isEmpty()){
                return -1;
            }
            return s2.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (!s2.isEmpty()){
            return s2.peek();
        }else{
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            if (s2.isEmpty()){
                return -1;
            }
            return s2.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty()&&s2.isEmpty();
    }
}
