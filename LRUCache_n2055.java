package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月15日 8:46 上午
 */
public class LRUCache_n2055 {
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
    int capaticy;
    int size;
    HashMap<Integer,DLinkNode> map;
    DLinkNode head;
    DLinkNode tail;
    public LRUCache_n2055(int _capacity) {
        map=new HashMap<>();
        this.capaticy=_capacity;
        this.size=0;
        head=new DLinkNode();
        tail=new DLinkNode();
        head.right=tail;
        tail.left=head;
    }

    public int get(int key) {
        DLinkNode node=map.get(key);
        if (node==null){
            return  -1;
        }
        moveTohead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node=map.get(key);
        if (node==null){
            DLinkNode newnode=new DLinkNode(key,value);
            addTohead(newnode);
            map.put(key,newnode);
            ++size;
            if (size>capaticy){
                DLinkNode tail=removeTail();
                map.remove(tail.key);
                --size;
            }
        }else{
            node.value=value;
            moveTohead(node);
        }
    }
    void addTohead(DLinkNode node){
        node.left=head;
        node.right=head.right;
        head.right.left= node;
        head.right=node;
    }
    void removeNode(DLinkNode node){
        node.left.right=node.right;
        node.right.left=node.left;
    }
    void moveTohead(DLinkNode node){
        removeNode(node);
        addTohead(node);
    }
    DLinkNode removeTail(){
        DLinkNode res=tail.left;
        removeNode(res);
        return res;
    }

}
