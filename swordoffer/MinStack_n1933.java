package leetcode.swordoffer;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月19日 8:05 下午
 */
public class MinStack_n1933 {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack_n1933() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) minStack.push(x);
        else{
            if (x<=minStack.peek()) minStack.push(x);
        }
    }

    public void pop() {
        int u=stack.pop();
        if (u==minStack.peek()) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
