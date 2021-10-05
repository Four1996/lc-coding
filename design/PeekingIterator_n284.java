package leetcode.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * @program: first
 * @description: 窥探迭代器
 * @author: panhao
 * @date: 2021-10-05 19:25
 **/
public class PeekingIterator_n284 implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer next;

    public PeekingIterator_n284(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ans = next;
        next = iter.hasNext() ? iter.next() : null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
