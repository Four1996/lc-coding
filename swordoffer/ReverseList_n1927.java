package leetcode.swordoffer;

import java.util.List;

/**
 * @author panhao
 * @date 2021年05月19日 11:05 上午
 */
public class ReverseList_n1927 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseList(ListNode head) {
        ListNode newHead=null;
        while (head!=null){
            ListNode node=new ListNode(head.val);
            if (newHead==null) newHead=node;
            else{
                node.next=newHead;
                newHead=node;
            }
            head=head.next;
        }
        return newHead;
    }
}
