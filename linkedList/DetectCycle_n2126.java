package leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: first
 * @description: 链表中环的入口节点
 * @author: panhao
 * @date: 2021-08-31 16:40
 **/
public class DetectCycle_n2126 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode tail = head;
        while (tail != null) {
            if (set.contains(tail)) {
                return tail;
            }
            set.add(tail);
            tail = tail.next;
        }
        return null;
    }
}
