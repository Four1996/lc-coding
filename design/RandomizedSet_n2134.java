package leetcode.design;

import java.util.*;

/**
 * @program: first
 * @description: 插入删除和随机访问都是O(1)的容器
 * @author: panhao
 * @date: 2021-09-02 15:39
 **/
public class RandomizedSet_n2134 {
    HashMap<Integer,Integer> map;
    Random r;
    int capacity;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet_n2134() {
        map=new HashMap<>();
        capacity=0;
        list=new ArrayList<>();
        r=new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }else{
            list.add(val);
            map.put(val,list.size()-1);
            capacity++;
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.get(val);
            int lastNum = list.get(list.size() - 1);
            capacity--;
            list.set(idx, lastNum);
            map.put(lastNum,idx);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int n=r.nextInt(capacity);
        return list.get(n);
    }
}
