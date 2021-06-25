package leetcode.classic;

/**
 * @program: first
 * @description: 分割链表
 * @author: panhao
 * @date: 2021-06-22 21:40
 **/
public class Partition_n2035 {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static ListNode partition(ListNode head, int x) {
       ListNode leftList=new ListNode(0);
       ListNode leftTail=leftList;
       ListNode tail=head;
       ListNode rightHead=new ListNode(0);
       ListNode rightTail=rightHead;
       while (tail!=null){
           if (tail.val<x){
               leftTail.next=new ListNode(tail.val);
               leftTail=leftTail.next;
           }else{
               rightTail.next=new ListNode(tail.val);
               rightTail=rightTail.next;
           }
           tail=tail.next;
       }
       leftTail.next=rightHead.next;
       return leftList.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(3);
        ListNode a1=new ListNode(2);
        ListNode a2=new ListNode(1);
        head.next=a1;
        a1.next=a2;
        System.out.println(partition(head,4));
    }
}
