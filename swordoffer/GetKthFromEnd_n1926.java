package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年05月19日 11:00 上午
 */
public class GetKthFromEnd_n1926 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tail=head;
        int len=0;
        while (tail!=null){
            len++;
            tail=tail.next;
        }
        tail=head;
        int count=0;
        while (count+k<len){
            count++;
            tail=tail.next;
        }
        return tail;
    }
}
