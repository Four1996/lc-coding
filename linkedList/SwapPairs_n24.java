package leetcode.linkedList;

/**
 * @program: first
 * @description: 两两交换链表中的结点
 * @author: panhao
 * @date: 2021-08-25 18:49
 **/
public class SwapPairs_n24 {
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

    public ListNode swapPairs(ListNode head) {
        ListNode newHead=new ListNode(-1);
        newHead.next=head;
        ListNode dumy=head;
        while (head.next!=null){
            dumy=dumy.next;
            if (dumy!=null){

            }
        }
        return newHead.next;
    }
}
