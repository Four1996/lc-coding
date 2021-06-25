package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年05月05日 6:58 下午
 */
public class HasCycle_n141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> map=new HashMap<>();
        for (ListNode tail=head;tail!=null;){
            if (map.containsKey(tail)) return true;
            map.put(tail,tail.val);
            tail=tail.next;
        }
        return false;
    }
    public boolean hasCycle2(ListNode head) {
        for (ListNode tail=head;tail!=null;){
            if (tail.val==Integer.MIN_VALUE) return true;
            tail.val=Integer.MIN_VALUE;
            tail=tail.next;
        }
        return false;
    }
}
