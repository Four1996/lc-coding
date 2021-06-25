package leetcode;

import java.util.Scanner;

public class DeleteDuplicates_3 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode deleteDuplicates_3(ListNode head){
        ListNode dummy=new ListNode();
        ListNode tail=dummy;
        if (head==null) return null;
        else if(head.next==null) {
        return head;
        }else{
            while(head!=null){
                if (head.next==null||head.val!=head.next.val){
                     tail.next=head;
                     tail=head;
                }
                if (head.next!=null&&head.val==head.next.val){
                    tail.next=head;
                    tail=head;
                    while (head.next!=null&&head.val==head.next.val){
                        head = head.next;
                    }
                }
                head=head.next;
            }
        }
        tail.next=null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode();
        ListNode newnode=head=null;
        Scanner input=new Scanner(System.in);
        int m=input.nextInt();
        while(m!=0){
            ListNode p=new ListNode(m);
            if (head==null){head=newnode=p;}
            else{
                newnode.next=p;
                newnode=p;
            }
            m=input.nextInt();
        }
        deleteDuplicates_3(head);
    }
}
