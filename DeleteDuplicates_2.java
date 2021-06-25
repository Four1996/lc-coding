package leetcode;

import java.util.Scanner;

public class DeleteDuplicates_2 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode deleteDuplicates_2(ListNode head){
        ListNode dummy=new ListNode();
        ListNode tail=dummy;
        while(head!=null){
            if (head.next==null||head.val!=head.next.val){
                tail.next=head;
                tail=head;
            }
            while(head.next!=null&&head.val==head.next.val){
                head=head.next;
            }
            head=head.next;
        }
        tail.next=null;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ListNode head = null;
        ListNode newhead = null;
        int m = input.nextInt();
        while (m != 0) {
            ListNode p = new ListNode(m);
            if (head == null) {
                newhead = head = p;
            } else {
                newhead.next = p;
                newhead = p;
            }
            m = input.nextInt();
        }
        deleteDuplicates_2(head);
    }
}
