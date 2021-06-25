package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年05月18日 9:25 下午
 */
public class DeleteNode_n1922 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val==val) return head.next;
        ListNode pre=head;
        ListNode tail=head.next;
        while (tail!=null){
            if (tail.val==val) break;
            pre=tail;
            tail=tail.next;
        }
        pre.next=tail.next;
        return head;
    }
}
