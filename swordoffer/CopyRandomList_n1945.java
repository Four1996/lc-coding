package leetcode.swordoffer;


import javax.persistence.Id;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author panhao
 * @date 2021年05月25日 9:43 上午
 */
public class CopyRandomList_n1945 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        Node dummy=head;
        HashMap<Node,Node> map=new HashMap<>();
        while (dummy!=null){
            map.put(dummy,new Node(dummy.val));
            dummy=dummy.next;
        }
        dummy=head;
        while (dummy!=null){
            map.get(dummy).next=map.get(dummy.next);
            map.get(dummy).random=map.get(dummy.random);
            dummy=dummy.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Node n1=new Node(3);
        Node n2=new Node(3);
        Node n3=new Node(3);
//        Node n4=new Node(10);
//        Node n5=new Node(1);
        n1.next=n2;
        n2.next=n3;
//        n3.next=n4;
//        n4.next=n5;
        n2.random=n1;
//        n3.random=n5;
//        n4.random=n3;
//        n5.random=n1;
        copyRandomList(n1);
    }
}
