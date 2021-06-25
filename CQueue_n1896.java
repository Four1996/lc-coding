package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月08日 3:27 下午
 */
public class CQueue_n1896 {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public CQueue_n1896() {
        this.s1=new Stack<>();
        this.s2=new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
        List<Integer> list=new ArrayList<>();
        while (!s2.isEmpty()){
            list.add(s2.pop());
        }
        list.add(value);
        for (int i=list.size()-1;i>=0;--i){
            s2.push(list.get(i));
        }
    }

    public int deleteHead() {
        if (s2.isEmpty()) return -1;
        return s2.pop();
    }

    public static void main(String[] args) {
        CQueue_n1896 c = new CQueue_n1896();
        System.out.println(c.deleteHead());
        c.appendTail(5);
        c.appendTail(2);
        System.out.println(c.deleteHead());
        System.out.println(c.deleteHead());
    }
}
