package leetcode.classic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: first
 * @description: LRU缓存
 * @author: panhao
 * @date: 2021-07-30 14:28
 **/
public class LRUCache_n2149 {
    // 自定义双向链表
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer,DLinkedNode> map;
    int capacity;
    private final DLinkedNode head;
    private final DLinkedNode tail;
    public LRUCache_n2149(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            moveToHead(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.getOrDefault(key, null);
        if (node==null){
            DLinkedNode newNode = new DLinkedNode(key, value);
            map.put(key,newNode);
            addToHead(newNode);
            if (map.size()>capacity){
                DLinkedNode last = removeTail();
                map.remove(last.key);
            }
        }else{
            node.value=value;
            moveToHead(node);
        }

    }

    private void addToHead(DLinkedNode node) {
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res=tail.pre;
        removeNode(res);
        return res;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    private void moveToHead(DLinkedNode node) {
        // 删除结点
        removeNode(node);
        // 移动到队头
        addToHead(node);
    }
}
