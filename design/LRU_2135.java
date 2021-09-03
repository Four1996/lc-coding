package leetcode.design;

import jdk.nashorn.internal.ir.IfNode;

import java.util.HashMap;

/**
 * @program: first
 * @description: 最近最少使用
 * @author: panhao
 * @date: 2021-09-02 16:40
 **/
public class LRU_2135 {
    class DeLinked {
        int key;
        int val;
        DeLinked pre;
        DeLinked next;

        public DeLinked() {
        }

        public DeLinked(int key, int val) {
            this.val = val;
            this.key = key;
        }

        public DeLinked(int key, int val, DeLinked pre, DeLinked next) {
            this.key = key;
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
        if (map.containsKey(key)){
            DeLinked node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DeLinked node;
        if (map.containsKey(key)){
            node = map.get(key);
            node.val=value;
            map.put(key,node);
            moveToHead(node);
            deleteNode(node);
        }else{
            node=new DeLinked(key,value);
            addToHead(node);
            map.put(key,node);
            if (map.size()>capacity){
                DeLinked tail=deleteTail();
                map.remove(tail.key);
            }
        }
    }

    private DeLinked deleteTail() {
        DeLinked node=tail.pre;
        deleteNode(node);
        return node;
    }

    private void addToHead(DeLinked node) {
        node.next=head.next;
        head.next.pre=node;
        node.pre=head;
        head.next=node;
    }

    private void deleteNode(DeLinked node) {
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    private void moveToHead(DeLinked node) {
        deleteNode(node);
        addToHead(node);
    }
}
