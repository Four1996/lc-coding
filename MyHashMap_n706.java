package leetcode;

/**
 * @program: first
 * @description: 设计哈希映射
 * @author: panhao
 * @date: 2021-07-04 19:04
 **/
public class MyHashMap_n706 {
    class Node{
        int val=-1;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
    Node[] node;
    public MyHashMap_n706() {
        node=new Node[1000006];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node temp=new Node(value);
        node[key]=temp;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (node[key]==null) return -1;
        return node[key].val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        node[key]=null;
    }
}
