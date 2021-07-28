package leetcode.design;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @program: first
 * @description: 堆盘子
 * @author: panhao
 * @date: 2021-07-28 21:01
 **/
public class StackOfPlates_n2085 {
    List<Deque<Integer>> s_list;
    int s_max;

    public StackOfPlates_n2085(int cap) {
        s_list = new ArrayList<>();
        s_max = cap;
    }

    public void push(int val) {
        if (s_max == 0) return;
        if (s_list.isEmpty()) s_list.add(new ArrayDeque<>());
        if (s_list.get(s_list.size()-1).size()==s_max) s_list.add(new ArrayDeque<>());
        s_list.get(s_list.size()-1).addFirst(val);
    }

    public int pop() {
        return popAt(s_list.size() - 1);
    }

    public int popAt(int index) {
        if (s_max == 0) return -1;
        if (index >= s_list.size() || index < 0) return -1;
        Integer pop = s_list.get(index).pollFirst();
        if (s_list.get(index).isEmpty()) {
            s_list.remove(index);
        }
        return pop==null?-1:pop;
    }
}
