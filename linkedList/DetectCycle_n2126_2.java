package leetcode.linkedList;

import java.nio.file.FileStore;

/**
 * @program: first
 * @description: 链表中环的入口节点_快慢指针(o(1)空间)
 * @author: panhao
 * @date: 2021-08-31 16:40
 **/
public class DetectCycle_n2126_2 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
