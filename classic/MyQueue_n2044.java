package leetcode.classic;

import java.util.Stack;

/**
 * @program: first
 * @description: 化栈为队
 * @author: panhao
 * @date: 2021-06-24 10:28
 **/
public class MyQueue_n2044 {
    Stack<Integer> input;
    Stack<Integer> output;
    /** Initialize your data structure here. */
    public MyQueue_n2044() {
        input=new Stack<>();
        output=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!output.isEmpty()) return output.pop();
        else{
            while (!input.isEmpty()){
                Integer pop = input.pop();
                output.push(pop);
            }
        }
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (output.isEmpty()){
            while (!input.isEmpty()){
                Integer pop = input.pop();
                output.push(pop);
            }
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return output.isEmpty()&&input.isEmpty();
    }
}
