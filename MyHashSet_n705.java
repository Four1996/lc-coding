package leetcode;

/**
 * @author panhao
 * @date 2021年04月10日 9:16 下午
 */
public class MyHashSet_n705 {
    boolean[] nodes=new boolean[1000009];
    public MyHashSet_n705() {

    }
    public void add(int key){
        nodes[key]=true;
    }
    public void remove(int key){
        nodes[key]=false;
    }
    public boolean contains(int key){
        return nodes[key];
    }
}
