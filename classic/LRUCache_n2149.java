package leetcode.classic;

import java.util.HashMap;

/**
 * @program: first
 * @description: LRU缓存
 * @author: panhao
 * @date: 2021-07-30 14:28
 **/
public class LRUCache_n2149 {
    int capacity;
    HashMap<Integer,Integer> map;
    public LRUCache_n2149(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
    }

    public int get(int key) {
        return -1;
    }

    public void put(int key, int value) {

    }
}
