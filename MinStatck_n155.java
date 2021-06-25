package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月05日 7:12 下午
 */
public class MinStatck_n155 {
    Stack<Integer> stack;
    Stack<Integer> helper;
    public MinStatck_n155() {
        stack=new Stack<>();
        helper=new Stack<>();

    }

    public void push(int val) {
        stack.push(val);
        if (!helper.isEmpty()){
            if (val>helper.peek()){
                helper.push(helper.peek());
            }else{
                helper.push(val);
            }
        }
        else{
            helper.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
        }
        if (!helper.isEmpty()){
            helper.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()){
            return stack.peek();
        }
        return Integer.MIN_VALUE;
    }

    public int getMin() {
        return  helper.peek();
    }
}
