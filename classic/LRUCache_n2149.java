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
    private DLinkedNode head,tail;
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
        if (map.size()==capacity){
            removeTail(tail);
            map.remove(tail.key);
            capacity--;
        }
        DLinkedNode node = new DLinkedNode(key, value);
        map.put(key,node);
        node.next=head;
        head.pre=node;
        head=node;
    }

    private void removeTail(DLinkedNode tail) {
        tail=tail.pre;
        tail.next=null;
    }

    private void moveToHead(DLinkedNode node) {
        DLinkedNode newNode = new DLinkedNode(node.key, node.value);
        // 删除结点
        node.pre.next=node.next;
        node.next.pre=node.pre;

        newNode.next=head;
        head.pre=newNode;
        head=newNode;
    }
}
