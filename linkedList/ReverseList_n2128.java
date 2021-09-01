package leetcode.linkedList;

import java.util.List;

/**
 * @program: first
 * @description: 反转链表
 * @author: panhao
 * @date: 2021-09-01 10:17
 **/
public class ReverseList_n2128 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
        ListNode newHead = head;
        ListNode tail = head;
        if (head!=null){
            head = head.next;
        }
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = newHead;
            newHead = node;
            head = head.next;
        }
        if (tail!=null){
            tail.next = null;
        }
        return newHead;
    }
}
