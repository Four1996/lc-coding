package leetcode.linkedList;

/**
 * @program: first
 * @description: 两个链表的第一个重合结点
 * @author: panhao
 * @date: 2021-09-01 10:08
 **/
public class GetIntersectionNode_n2127 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tailA = headA;
        ListNode tailB = headB;
        while (tailA != tailB) {
            tailA = tailA == null ? headB : tailA.next;
            tailB = tailB == null ? headA : tailB.next;
        }
        return tailA;
    }
}
