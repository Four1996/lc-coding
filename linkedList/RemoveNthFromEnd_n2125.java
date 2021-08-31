package leetcode.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 删除链表的倒数第n个结点
 * @author: panhao
 * @date: 2021-08-31 16:33
 **/
public class RemoveNthFromEnd_n2125 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode tail = head;
        while (tail != null) {
            list.add(tail);
            tail = tail.next;
        }
        int size = list.size();
        if (head == null) {
            return null;
        } else if (n == size) {
            return head.next;
        } else if (n == 1) {
            list.get(size - 2).next = null;
            return head;
        } else {
            list.get(size - n - 1).next = list.get(size - n + 1);
            return head;
        }
    }
}
