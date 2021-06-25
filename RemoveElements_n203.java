package leetcode;

import java.util.List;

/**
 * @author panhao
 * @date 2021年06月05日 9:00 上午
 */
public class RemoveElements_n203 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeElements(ListNode head, int val) {

        ListNode pre=new ListNode();
        pre.next=head;
        ListNode cur=head;
        ListNode dumy=pre;
        while (cur!=null){
            if (cur.val==val) {
                cur=cur.next;
                pre.next=cur;
            }else{
                pre=pre.next;
                cur=cur.next;
            }
        }
        return dumy.next;
    }
}
