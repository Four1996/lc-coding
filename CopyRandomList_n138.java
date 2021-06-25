package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月25日 10:36 上午
 */
public class CopyRandomList_n138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node dummy = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (dummy != null) {
            map.put(dummy, new Node(dummy.val));
            dummy = dummy.next;
        }
        dummy = head;
        while (dummy != null) {
            map.get(dummy).next = map.get(dummy.next);
            map.get(dummy).random = map.get(dummy.random);
            dummy = dummy.next;
        }
        return map.get(head);
    }
}
