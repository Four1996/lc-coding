package leetcode.design;

import java.util.HashMap;

/**
 * @program: first
 * @description: 最近最少使用
 * @author: panhao
 * @date: 2021-09-02 16:40
 **/
public class LRU_2135 {
    class DeLinked {
        int val;
        DeLinked pre;
        DeLinked next;

        public DeLinked() {
        }

        public DeLinked(int val) {
            this.val = val;
        }

        public DeLinked(int val, DeLinked pre, DeLinked next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
    HashMap<Integer, DeLinked> map;
    int capacity;
    DeLinked head;
    DeLinked tail;
    public LRU_2135(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        head=new DeLinked();
        tail=new DeLinked();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

    }
}
