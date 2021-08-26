package leetcode.design;

import java.util.HashMap;

/**
 * @program: first
 * @description: LRU
 * @author: panhao
 * @date: 2021-08-25 20:50
 **/
public class LRU_n146 {
    class DLinkNode{
        int key;
        int value;
        DLinkNode left;
        DLinkNode right;

        public DLinkNode() {
        }

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    int size;
    HashMap<Integer,DLinkNode> map;
    DLinkNode head;
    DLinkNode tail;
    public LRU_n146(int _capacity) {
        capacity = _capacity;
        map = new HashMap<>();
        head = new DLinkNode();
        tail = new DLinkNode();
        head.right = tail;
        tail.left = head;
    }
    public int get(int key){
        DLinkNode node = map.getOrDefault(key,null);
        if (node==null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    public void put(int key,int value){
        DLinkNode node = map.getOrDefault(key,null);
        if (node==null){
            node=new DLinkNode(key,value);
            addToHead(node);
            map.put(key,node);
            size++;
            if (size>capacity){
                DLinkNode tailNode=removeTail();
                map.remove(tailNode.key);
                size--;
            }
        }else{
            node.value=value;
            map.put(key,node);
            moveToHead(node);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode node=tail.left;
        removeNode(node);
        return node;
    }

    private void removeNode(DLinkNode node) {
        node.left.right=node.right;
        node.right.left=node.left;
    }

    private void addToHead(DLinkNode node) {
        node.right=head.right;
        node.left=head;
        head.right=node;
        node.right.left=node;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }
}
