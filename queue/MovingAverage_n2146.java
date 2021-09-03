package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: first
 * @description: 滑动窗口的平均值
 * @author: panhao
 * @date: 2021-09-03 22:19
 **/
public class MovingAverage_n2146 {
    int size;
    Deque<Integer> deque;
    Double sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage_n2146(int size) {
        this.size = size;
        deque = new ArrayDeque<>();
        sum = 0.0;
    }

    public double next(int val) {
        deque.addFirst(val);
        sum += val;
        if (deque.size() > size) {
            Integer integer = deque.pollLast();
            sum -= integer;
        }
        return sum / deque.size();
    }
}
